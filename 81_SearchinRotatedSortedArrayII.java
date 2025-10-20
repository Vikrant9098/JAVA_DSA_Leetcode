class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  // Initialize binary search boundaries

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate middle index

            if (nums[mid] == target) return true;  // Found target

            // If duplicates prevent determining the sorted half
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;   // Shrink left boundary
                right--;  // Shrink right boundary
            }
            // Left part is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // Target is in left sorted part
                } else {
                    left = mid + 1;   // Target is in right part
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // Target is in right sorted part
                } else {
                    right = mid - 1;  // Target is in left part
                }
            }
        }

        return false;  // Target not found
    }
}
