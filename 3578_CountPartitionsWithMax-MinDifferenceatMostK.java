class Solution {                                           // class definition
    public int countPartitions(int[] nums, int k) {        // function to count valid partitions
        int n = nums.length, MOD = 1_000_000_007;          // n = size of array, MOD = large prime
        long[] dp = new long[n + 1];                       // dp array to store number of ways
        dp[0] = 1;                                          // base case: empty prefix has 1 way

        java.util.Deque<Integer> mx = new java.util.ArrayDeque<>(); // deque to track maximums
        java.util.Deque<Integer> mn = new java.util.ArrayDeque<>(); // deque to track minimums
        long sum = 0;                                       // running sum of valid dp values
        int l = 0;                                          // left pointer of sliding window

        for (int r = 0; r < n; r++) {                       // loop through each index as right pointer
            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[r]) mx.pollLast();
                                                            // remove smaller or equal values from mx
            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[r]) mn.pollLast();
                                                            // remove bigger or equal values from mn
            mx.add(r);                                      // add current index to max deque
            mn.add(r);                                      // add current index to min deque

            while (nums[mx.peek()] - nums[mn.peek()] > k) { // shrink window if invalid (max-min > k)
                if (mx.peek() == l) mx.poll();              // remove left element from max deque
                if (mn.peek() == l) mn.poll();              // remove left element from min deque
                sum = (sum - dp[l] + MOD) % MOD;            // subtract dp[l] from running sum
                l++;                                        // move left pointer forward
            }

            sum = (sum + dp[r]) % MOD;                      // add dp[r] to running sum
            dp[r + 1] = sum;                                // dp for next position is current sum
        }
        return (int) dp[n];                                 // return result for full array
    }
}
