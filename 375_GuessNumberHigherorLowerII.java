class Solution {
    public int getMoneyAmount(int n) {
        // dp[i][j] = minimum money needed to guarantee a win between numbers i and j
        int[][] dp = new int[n + 1][n + 1];

        // loop over all possible range lengths (from 2 to n)
        for (int len = 2; len <= n; len++) {
            // start of the range
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;       // end of the range
                dp[start][end] = Integer.MAX_VALUE; // set to large number initially

                // try every number 'x' as the guess point
                for (int x = start; x < end; x++) {
                    // cost = money you pay for guessing x
                    // + worst case of left or right side (since we must guarantee a win)
                    int cost = x + Math.max(dp[start][x - 1], dp[x + 1][end]);

                    // choose the smallest cost among all guesses
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        // return the minimum money needed to guarantee a win between 1 and n
        return dp[1][n];
    }
}
