import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        // Sort the array in non-decreasing order
        Arrays.sort(nums);
        
        // Start checking from the largest side (end of the array)
        for (int i = nums.length - 1; i >= 2; i--) {
            // For a valid triangle: nums[i-2] + nums[i-1] > nums[i]
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                // Return the perimeter
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        
        // If no valid triangle found, return 0
        return 0;
    }
}
