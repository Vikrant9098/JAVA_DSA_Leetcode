class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        // Keep reducing until only one element remains
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                // Replace nums[i] with (nums[i] + nums[i+1]) % 10
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; // Reduce the size for the next row
        }

        // The first element will hold the triangular sum
        return nums[0];
    }
}
