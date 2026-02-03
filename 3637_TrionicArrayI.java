class Solution {                 // Define the Solution class

    public boolean isTrionic(int[] nums) {   // Method to check if array is trionic
        int n = nums.length;     // Store length of the array

        if (nums[0] >= nums[1]) { // First two elements must be increasing
            return false;        // Otherwise, not trionic
        }

        int count = 1;           // Count number of direction changes

        for (int i = 2; i < n; i++) { // Loop from third element to end
            if (nums[i - 1] == nums[i]) { // Check for equal adjacent elements
                return false;    // Equal values are not allowed
            }

            // Check if trend changes (increasing to decreasing or vice versa)
            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++;         // Increase count on direction change
            }
        }

        return count == 3;       // Valid trionic array has exactly 3 segments
    }
}
