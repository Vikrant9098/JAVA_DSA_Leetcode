class Solution {
    public int findMin(int[] nums) {
        // Left and right pointers
        int left = 0;
        int right = nums.length - 1;

        // Binary search to find minimum element
        while (left < right) {
            // Find middle index
            int mid = left + (right - left) / 2;

            // If middle element is greater than right element,
            // the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Otherwise, the minimum is in the left half (including mid)
            else {
                right = mid;
            }
        }

        // Left now points to the smallest element
        return nums[left];
    }
}
