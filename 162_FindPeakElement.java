class Solution {
    public int findPeakElement(int[] nums) {
        // Initialize the binary search boundaries
        int low = 0;
        int high = nums.length - 1;

        // Perform binary search to find a peak
        while (low < high) {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // Compare the middle element with its right neighbor
            if (nums[mid] > nums[mid + 1]) {
                // If middle element is greater than the next one,
                // the peak is on the left side (including mid)
                high = mid;
            } else {
                // If middle element is less than the next one,
                // the peak is on the right side (excluding mid)
                low = mid + 1;
            }
        }

        // When low == high, we've found a peak element
        return low;
    }
}
