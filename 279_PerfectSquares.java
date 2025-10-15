class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp[i] = fewest perfect squares that sum to i
        Arrays.fill(dp, Integer.MAX_VALUE); // fill with large values initially
        dp[0] = 0; // base case: 0 can be made with 0 squares

        // loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // try every square number less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // choose the minimum between current and using square j*j
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n]; // return the result for n
    }
}
