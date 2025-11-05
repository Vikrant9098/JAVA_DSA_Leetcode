class Solution 
{
    public long[] findXSum(int[] nums, int k, int x) 
    {
        int n = nums.length;                            // length of the input array
        long[] ans = new long[n - k + 1];               // result array for each window’s x-sum

        // Step 1: Initialize frequency map and ordering rules
        HashMap<Integer, Integer> freq = new HashMap<>(); // stores frequency of each number
        
        // Comparator to sort numbers first by frequency, then by value
        Comparator<Integer> cmp = (a, b) -> {
            int fa = freq.getOrDefault(a, 0), fb = freq.getOrDefault(b, 0); // get frequencies
            if (fa != fb) return Integer.compare(fa, fb);   // smaller freq = smaller in order
            return Integer.compare(a, b);                   // if same freq, smaller value first
        };

        TreeSet<Integer> topX = new TreeSet<>(cmp);     // stores top x frequent elements
        TreeSet<Integer> rest = new TreeSet<>(cmp);     // stores the remaining elements
        long sumTop = 0L;                               // keeps current sum of top x elements

        // Step 2: Comparator already defined above (for sorting)

        for (int i = 0; i < n; i++)                     // loop through each number
        {
            int v = nums[i];                            // current incoming element

            // Step 3: Remove old value of v (if exists) before updating
            int old = freq.getOrDefault(v, 0);          // get old frequency
            if (old > 0)                                // if element already present
            {
                if (topX.remove(v))                     // if it was in topX, remove it
                {
                    sumTop -= (long) old * v;           // subtract its contribution from sum
                } 
                else 
                {
                    rest.remove(v);                     // else remove from rest set
                }
            }

            freq.put(v, old + 1);                       // increase frequency by 1
            rest.add(v);                                // temporarily add to rest set

            // Step 4: Balance topX and rest after change
            sumTop = rebalance(topX, rest, freq, x, sumTop);

            // Step 5 & 6: Remove the element that moves out of window
            if (i >= k)                                // once window exceeds size k
            {
                int u = nums[i - k];                    // element going out from left
                int oldU = freq.get(u);                 // get its old frequency

                if (topX.remove(u))                     // if in topX, remove and subtract from sum
                {
                    sumTop -= (long) oldU * u;
                } 
                else 
                {
                    rest.remove(u);                     // else remove from rest
                }

                if (oldU == 1)                          // if frequency becomes 0
                {
                    freq.remove(u);                     // delete it from freq map
                } 
                else 
                {
                    freq.put(u, oldU - 1);              // else decrease its count
                    rest.add(u);                        // and reinsert to rest
                }

                sumTop = rebalance(topX, rest, freq, x, sumTop); // rebalance sets again
            }

            // Step 7: Record the current window’s x-sum
            if (i >= k - 1)                             // valid window formed
            {
                ans[i - k + 1] = sumTop;                // store x-sum in result
            }
        }

        // Step 9: Return final result array
        return ans;
    }

    // Rebalancing function: ensures topX has exactly top 'x' frequent/largest elements
    public long rebalance(TreeSet<Integer> topX, TreeSet<Integer> rest, Map<Integer,Integer> freq, int x, long sumTop) 
    {
        // If topX has less than x elements, move best ones from rest
        while (topX.size() < x && !rest.isEmpty()) 
        {
            int best = rest.last();                     // get highest ranked element
            rest.remove(best);                          // remove from rest
            topX.add(best);                             // add to topX
            sumTop += (long) freq.get(best) * best;     // add its contribution to sum
        }

        // If topX has more than x elements, move worst ones to rest
        while (topX.size() > x) 
        {
            int worst = topX.first();                   // smallest ranked in topX
            topX.remove(worst);                         // remove it
            rest.add(worst);                            // move to rest
            sumTop -= (long) freq.get(worst) * worst;   // subtract from sum
        }

        // If rest has a better candidate, swap with worst in topX
        while (!topX.isEmpty() && !rest.isEmpty()) 
        {
            int worstTop = topX.first();                // weakest in topX
            int bestRest = rest.last();                 // strongest in rest
            int fw = freq.get(worstTop), fr = freq.get(bestRest); // their frequencies

            // If rest element is better (higher freq or same freq but larger value)
            if (fr > fw || (fr == fw && bestRest > worstTop)) 
            {
                topX.remove(worstTop);                  // remove weak from topX
                rest.remove(bestRest);                  // remove strong from rest
                topX.add(bestRest);                     // move strong to topX
                rest.add(worstTop);                     // move weak to rest
                sumTop += (long) fr * bestRest - (long) fw * worstTop; // adjust sum
            } 
            else 
            {
                break;                                  // stop if order is already correct
            }
        }
        
        return sumTop;                                  // return updated x-sum
    }
}
