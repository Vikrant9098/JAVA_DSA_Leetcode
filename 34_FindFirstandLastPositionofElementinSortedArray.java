class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Result array to store first and last positions
        int[] result = {-1, -1};

        // Find first occurrence of target
        int first = findBound(nums, target, true);

        // If first is not found, no need to search for last
        if (first == -1) {
            return result;
        }

        // Find last occurrence of target
        int last = findBound(nums, target, false);

        // Store results
        result[0] = first;
        result[1] = last;

        return result;
    }

    // Helper function to find boundary (first or last position)
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target found, record position
            if (nums[mid] == target) {
                bound = mid;
                // If finding first occurrence, move left
                if (isFirst) {
                    right = mid - 1;
                }
                // If finding last occurrence, move right
                else {
                    left = mid + 1;
                }
            } 
            // Move right if mid value is less than target
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            // Move left if mid value is greater than target
            else {
                right = mid - 1;
            }
        }

        return bound;
    }
}
