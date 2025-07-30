class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0; // Initialize variable to store the maximum value in the array

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num); // Update maxVal if current num is greater
        }

        int maxLength = 0;      // Stores the maximum length of subarray with AND = maxVal
        int currentLength = 0;  // Temporary counter to track the current streak of maxVal

        // Step 2: Traverse the array to find longest contiguous subarray with value == maxVal
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++; // If current number is equal to maxVal, extend the streak
                maxLength = Math.max(maxLength, currentLength); // Update maxLength if needed
            } else {
                currentLength = 0; // Reset currentLength if number is not equal to maxVal
            }
        }

        return maxLength; // Return the longest length of subarray with AND = maxVal
    }
}
