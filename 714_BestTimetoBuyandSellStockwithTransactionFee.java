class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // hold = max profit when we are holding a stock
        // cash = max profit when we are not holding any stock
        int hold = -prices[0]; // initially we buy at day 0
        int cash = 0;          // initially we have 0 profit (no stock)

        for (int i = 1; i < n; i++) {
            // update cash: either do nothing or sell stock today
            cash = Math.max(cash, hold + prices[i] - fee);

            // update hold: either do nothing or buy today
            hold = Math.max(hold, cash - prices[i]);
        }

        // at the end, max profit will be in cash (not holding any stock)
        return cash;
    }
}
