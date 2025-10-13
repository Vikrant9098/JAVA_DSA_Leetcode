class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length; // Number of days
        if (n == 0) return 0; // No prices → no profit

        // If k >= n/2, treat as unlimited transactions
        if (k >= n / 2) {
            int profit = 0; // Initialize profit
            for (int i = 1; i < n; i++) // Loop through days
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1]; // Add positive diffs
            return profit; // Return total profit
        }

        int[] buy = new int[k + 1]; // Max profit after t-th buy
        int[] sell = new int[k + 1]; // Max profit after t-th sell

        for (int i = 0; i <= k; i++) buy[i] = Integer.MIN_VALUE; // Init buy with very low value

        for (int price : prices) { // Loop through each price
            for (int t = 1; t <= k; t++) { // Loop through transaction counts
                buy[t] = Math.max(buy[t], sell[t - 1] - price); // Max profit after buying
                sell[t] = Math.max(sell[t], buy[t] + price);    // Max profit after selling
            }
        }

        return sell[k]; // Return max profit after at most k transactions
    }
}
