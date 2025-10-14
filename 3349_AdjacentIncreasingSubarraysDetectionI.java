class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size(); // get total number of elements

        // loop till we have space for two subarrays of size k
        for (int i = 0; i + 2 * k <= n; i++) {
            // check if both subarrays are strictly increasing
            if (isIncreasing(nums, i, i + k) && isIncreasing(nums, i + k, i + 2 * k)) {
                return true; // found two increasing adjacent subarrays
            }
        }
        return false; // no such pair found
    }

    // helper method to check if subarray from index l to r-1 is strictly increasing
    private boolean isIncreasing(List<Integer> nums, int l, int r) {
        // check each pair in the range
        for (int i = l; i < r - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) return false; // not strictly increasing
        }
        return true; // all pairs increasing
    }
}
