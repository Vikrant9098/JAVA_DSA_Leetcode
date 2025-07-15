class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0; // Calculate the total sum of the array
        int leftSum = 0; // Initialize the left sum

        // Calculate the total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            // Right sum can be calculated as totalSum - leftSum - nums[i]
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) { // Check if left sum equals right sum
                return i; // Return the pivot index
            }

            leftSum += nums[i]; // Update the left sum for the next iteration
        }

        return -1; // Return -1 if no pivot index is found
    }
}
