class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // farthest index we can reach so far

        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond maxReach, we cannot move further
            if (i > maxReach) {
                return false;
            }
            // Update maxReach
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can reach or go beyond the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
