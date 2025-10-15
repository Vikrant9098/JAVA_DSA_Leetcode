class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num; // calculate total sum of array

        // if sum is odd, cannot split into two equal subsets
        if (sum % 2 != 0) return false;

        int target = sum / 2; // sum each subset must reach
        boolean[] dp = new boolean[target + 1]; // dp[i] = whether sum i is possible
        dp[0] = true; // sum 0 is always possible

        // iterate through numbers
        for (int num : nums) {
            // iterate backwards to avoid using the same number multiple times
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num]; // include num or not
            }
        }

        return dp[target]; // can we reach sum/2?
    }
}
