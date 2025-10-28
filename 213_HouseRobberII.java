class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // only one house
        if (n == 2) return Math.max(nums[0], nums[1]); // pick max of two

        // Case 1: rob from house 0 to n-2
        int case1 = robLinear(nums, 0, n - 2);
        // Case 2: rob from house 1 to n-1
        int case2 = robLinear(nums, 1, n - 1);

        // return the better option
        return Math.max(case1, case2);
    }

    // Helper to solve normal House Robber (linear version)
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2; // rob current + dp[i-2]
            int skip = prev1;           // skip current
            int curr = Math.max(pick, skip); // choose best
            prev2 = prev1;              // move window
            prev1 = curr;
        }
        return prev1;
    }
}
