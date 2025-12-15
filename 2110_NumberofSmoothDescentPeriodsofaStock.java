class Solution {                          // Define the Solution class
    public static long getDescentPeriods(int[] prices) { // Method to count descent periods
        long dp = 1;                      // Length of current descending sequence
        long ans = 1;                     // Total count of descent periods

        for (int i = 1; i < prices.length; i++) { // Loop from second element to end
            if (prices[i - 1] - 1 == prices[i])    // Check if current price is 1 less than previous
                dp++;                              // Extend the descending sequence
            else
                dp = 1;                            // Reset sequence length
            ans += dp;                             // Add current sequence count to answer
        }
        return ans;                                // Return total descent periods
    }
}
