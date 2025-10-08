class Solution {
    public int search(int[] nums, int target) {
        // Left pointer
        int left = 0;
        // Right pointer
        int right = nums.length - 1;

        // Binary search loop
        while (left <= right) {
            // Find middle index
            int mid = left + (right - left) / 2;

            // If middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Move search to left half
                } else {
                    left = mid + 1; // Move search to right half
                }
            }
            // Otherwise, right half is sorted
            else {
                // Check if target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Move search to right half
                } else {
                    right = mid - 1; // Move search to left half
                }
            }
        }

        // Target not found
        return -1;
    }
}
