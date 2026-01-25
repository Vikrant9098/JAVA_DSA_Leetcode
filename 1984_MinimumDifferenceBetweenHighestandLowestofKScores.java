class Solution {                     // Define the Solution class

    public int minimumDifference(int[] nums, int k) {  // Function to find minimum difference
        if (k == 1) return 0;        // If only one element, difference is 0

        Arrays.sort(nums);           // Sort the array in ascending order
		
        int i = 0,                   // Left pointer
            j = k - 1,               // Right pointer (k elements apart)
            min = Integer.MAX_VALUE; // Store minimum difference

        while (j < nums.length) {    // Loop while right pointer is in bounds
            min = Math.min(          // Update minimum difference
                    min,             // Previous minimum
                    nums[j++] - nums[i++] // Difference and move both pointers
            );
        }

        return min;                  // Return the minimum difference found
    }
}

// TC: O(n log n) → sorting + O(n) sliding window
// SC: O(1) → no extra space used
