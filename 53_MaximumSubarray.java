class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize with the first element
        int currSum = nums[0]; // Track current subarray sum

        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start new from current element
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Update maxSum if current sum is greater
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum; // Return the maximum subarray sum found
    }
}
