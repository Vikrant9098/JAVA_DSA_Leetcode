class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;      // Number of rows
        int n = matrix[0].length;   // Number of columns
        int[][] dp = new int[m + 1][n + 1]; // DP table with extra row and column
        int maxSide = 0;            // Track maximum square side

        for (int i = 1; i <= m; i++) {         // Loop through rows
            for (int j = 1; j <= n; j++) {     // Loop through columns
                if (matrix[i - 1][j - 1] == '1') { // Only consider '1's
                    // DP relation: current cell = min(top, left, top-left) + 1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]); // Update max side
                }
            }
        }

        return maxSide * maxSide; // Return area of largest square
    }
}
