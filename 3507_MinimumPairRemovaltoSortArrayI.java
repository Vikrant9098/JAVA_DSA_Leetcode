class Solution {                       // Define Solution class

    public int minPair(List<Integer> v) {   // Function to find index of minimum adjacent sum
        int minSum = (int)1e9;              // Initialize minimum sum with large value
        int pos = -1;                       // Store position of minimum sum pair

        for(int i = 0; i < v.size() - 1; i ++){ // Loop through adjacent elements
            int sum = v.get(i) + v.get(i + 1);  // Calculate sum of adjacent pair
            if (sum < minSum) {                 // Check if current sum is smaller
                minSum = sum;                   // Update minimum sum
                pos = i;                        // Store index of this pair
            }
        }
        return pos;                             // Return index of minimum sum pair
    }

    public void mergePair(List<Integer> v, int pos) { // Merge adjacent pair at position pos
        v.set(pos, v.get(pos) + v.get(pos + 1)); // Replace element with sum of pair
        v.remove(pos + 1);                       // Remove the next element
    }

    public int minimumPairRemoval(int[] nums) { // Main function to count operations
        List<Integer> v = new ArrayList<>();    // Create list to store numbers
        for(int x : nums) v.add(x);              // Copy array elements into list

        int ops = 0;                             // Counter for operations
        while(!isSorted(v)){                     // Repeat until list becomes sorted
            int pos = minPair(v);                // Find position of minimum sum pair
            mergePair(v, pos);                   // Merge that pair
            ops++;                               // Increment operation count
        }
        return ops;                              // Return total operations
    }

    private boolean isSorted(List <Integer> v) { // Check if list is sorted
        for(int i = 0; i < v.size() - 1; i ++){  // Traverse list
            if(v.get(i) > v.get(i + 1)) return false; // If not sorted, return false
        }
        return true;                             // Return true if sorted
    }
}
