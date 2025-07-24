class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array (dp) where dp[i][j] represents the number of unique paths to reach cell (i, j)
        int[][] dp = new int[m][n];

        // Initialize the first column: There is only one way to reach any cell in the first column (by always moving down)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first row: There is only one way to reach any cell in the first row (by always moving right)
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the dp array using the relation:
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // This is because the robot can come either from the top (i-1, j) or from the left (i, j-1)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the total number of unique paths to reach the bottom-right cell (m-1, n-1)
        return dp[m - 1][n - 1];
    }
}
