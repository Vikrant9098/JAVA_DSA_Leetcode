class Solution {                          // Defines the Solution class

    public long maxProfit(int[] prices, int[] strategy, int k) { 
                                              // Method to calculate maximum profit

        final int n = prices.length;          // Total number of days
        final int k2 = k / 2;                 // Half of k (used for middle window logic)

        long[] sum = new long[n + 1];         // Prefix sum array for strategy-based profit
        long modify = 0;                      // Stores extra profit from modified window
        long sum_ = 0;                        // Running prefix sum

        for (int i = 0; i < n; i++) {         // Loop through all days
            final int x = prices[i];          // Price on day i

            sum[i + 1] = sum_ += strategy[i] * x;
                                              // Add strategy[i] * price to prefix sum

            modify += ((i >= k2 & i < k) ? x : 0);
                                              // Add price if index is in [k/2 , k)
        }

        long profit = Math.max(
                sum[n],                       // Profit without any modification
                modify + sum[n] - sum[k]      // Profit with initial modified window
        );

        for (int i = 1; i + k <= n; i++) {    // Slide the window of size k
            modify += prices[i + k - 1]       // Add new price entering window
                    - prices[i + k2 - 1];    // Remove price leaving middle window

            profit = Math.max(
                    profit,                   // Keep previous maximum profit
                    modify + sum[n] - sum[i + k] + sum[i]
                                              // Calculate profit for current window
            );
        }

        return profit;                        // Return maximum profit found
    }
}
