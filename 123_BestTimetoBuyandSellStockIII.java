class Solution {
    public int maxProfit(int[] prices) {
        // If there are no prices, no profit
        if (prices.length == 0) return 0;

        int buy1 = Integer.MAX_VALUE;  // Minimum price for first buy
        int profit1 = 0;               // Max profit after first sell
        int buy2 = Integer.MAX_VALUE;  // Effective cost after second buy
        int profit2 = 0;               // Max profit after second sell

        // Loop through all prices
        for (int price : prices) {
            buy1 = Math.min(buy1, price);             // Find lowest price for first buy
            profit1 = Math.max(profit1, price - buy1); // Max profit after first sell
            buy2 = Math.min(buy2, price - profit1);    // Use profit1 to lower second buy cost
            profit2 = Math.max(profit2, price - buy2); // Max profit after second sell
        }

        return profit2; // Final max profit after at most 2 transactions
    }
}
