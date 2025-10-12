class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the fewest coins needed to make amount i
        int[] dp = new int[amount + 1];
        
        // Fill dp with a large number (infinity)
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 amount needs 0 coins
        dp[0] = 0;

        // Loop for each amount from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Check each coin
            for (int coin : coins) {
                // If coin can be used (not more than current amount)
                if (coin <= i) {
                    // Take the minimum coins needed
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is not updated, return -1 (not possible)
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
