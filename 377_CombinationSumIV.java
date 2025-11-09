class Solution {
    public int combinationSum4(int[] nums, int target) {
        // create a dp array to store number of combinations for each sum
        int[] dp = new int[target + 1];
        
        // base case: there's 1 way to make sum 0 (by choosing nothing)
        dp[0] = 1;

        // loop through all targets from 1 to target
        for (int i = 1; i <= target; i++) {
            // for each number in nums
            for (int num : nums) {
                // if num can be used to make the current sum i
                if (i - num >= 0) {
                    // add the ways to make (i - num) to dp[i]
                    dp[i] += dp[i - num];
                }
            }
        }

        // dp[target] stores total number of combinations
        return dp[target];
    }
}
