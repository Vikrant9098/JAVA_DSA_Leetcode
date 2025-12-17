class Solution {

    // Function to calculate maximum profit
    static public long maximumProfit(int[] prices, int k) {

        long ans = 0;                 // Variable (not used, can be ignored)
        int n = prices.length;        // Number of days

        // 3D DP array: day, remaining transactions, state
        Long[][][] dp = new Long[n][k + 1][3];

        // Start recursion from day 0 with k transactions and state 0
        long res = solve(0, k, 0, n, prices, dp);

        return res;                   // Return final maximum profit
    }

    // Recursive DP function
    static long solve(int i, int k, int decider, int n, int[] prices, Long[][][] dp) {

        // If all days are processed
        if (i == n) {
            // Valid state: no stock in hand
            if (k >= 0 && decider == 0)
                return 0;
            // Invalid state
            return Integer.MIN_VALUE;
        }

        // If already calculated, return stored value
        if (dp[i][k][decider] != null) {
            return dp[i][k][decider];
        }

        // Initialize choices
        long take = Integer.MIN_VALUE;
        long dontTake = Integer.MIN_VALUE;

        // If transactions are still allowed
        if (k > 0) {

            // If selling state
            if (decider == 1) { 
                // Sell stock
                take = prices[i] + solve(i + 1, k - 1, 0, n, prices, dp);
            }

            // If buying state
            else if (decider == 2) { 
                // Buy stock
                take = -prices[i] + solve(i + 1, k - 1, 0, n, prices, dp);
            }

            // Neutral state (can buy or sell)
            else {
                take = Math.max(
                        // Sell
                        prices[i] + solve(i + 1, k, 2, n, prices, dp),
                        // Buy
                        -prices[i] + solve(i + 1, k, 1, n, prices, dp)
                );
            }
        }

        // Skip current day
        dontTake = solve(i + 1, k, decider, n, prices, dp);

        // Store and return best result
        return dp[i][k][decider] = Math.max(take, dontTake);
    }
}
