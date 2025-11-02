class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0; // if only one day or empty, no profit possible

        int[] hold = new int[n];    // max profit when holding a stock
        int[] sold = new int[n];    // max profit when selling a stock
        int[] rest = new int[n];    // max profit when in cooldown (no action)

        // base cases
        hold[0] = -prices[0]; // if we buy on first day
        sold[0] = 0;          // cannot sell on first day
        rest[0] = 0;          // rest (do nothing)

        for (int i = 1; i < n; i++) {
            // either keep holding or buy today after cooldown
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);

            // sell today from a hold state
            sold[i] = hold[i - 1] + prices[i];

            // rest can come from previous rest or sold (cooldown day)
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        // final profit will be max of sold or rest (not holding any stock)
        return Math.max(sold[n - 1], rest[n - 1]);
    }
}
