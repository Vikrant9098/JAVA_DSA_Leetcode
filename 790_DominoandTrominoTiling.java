class Solution {
    public int numTilings(int n) {
        // Define the modulo value as per the problem constraint
        int MOD = 1000000007;

        // Base Case: For n = 1, only 1 way to tile using a vertical domino
        if (n == 1) {
            return 1;
        }

        // Base Case: For n = 2, two ways - two vertical dominoes or two horizontal dominoes
        if (n == 2) {
            return 2;
        }

        // Base Case: For n = 3, five valid ways to tile the board with dominos and trominos
        if (n == 3) {
            return 5;
        }

        // Create an array to store the number of ways to tile the board for each size
        int[] dp = new int[n + 1];

        // Initialize base values
        dp[1] = 1; // One way to tile 2x1
        dp[2] = 2; // Two ways to tile 2x2
        dp[3] = 5; // Five ways to tile 2x3

        // Fill the dp array using the recurrence relation
        for (int i = 4; i <= n; i++) {
            // dp[i] = 2 * dp[i - 1] + dp[i - 3]
            // 2 * dp[i - 1] => Place vertical domino or L-tromino (mirror cases)
            // dp[i - 3] => Place an L-tromino that spans three columns
            dp[i] = (int)(((2L * dp[i - 1]) % MOD + dp[i - 3]) % MOD);
            // Use 2L to avoid integer overflow while multiplying
        }

        // Return the final result
        return dp[n];
    }
}
