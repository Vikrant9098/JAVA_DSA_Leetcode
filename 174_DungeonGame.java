class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;              // Number of rows
        int n = dungeon[0].length;           // Number of columns
        
        int[][] dp = new int[m][n];          // DP table to store min health needed from (i, j) to end
        
        // Base case: bottom-right cell (princess's room)
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);  // At least 1 health needed to survive
        
        // Fill the last row (only can move right)
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);  // From right to left
        }
        
        // Fill the last column (only can move down)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);  // From bottom to top
        }
        
        // Fill the rest of the grid (bottom-right to top-left)
        for (int i = m - 2; i >= 0; i--) {              // Loop rows upward
            for (int j = n - 2; j >= 0; j--) {          // Loop columns leftward
                int minHealthNext = Math.min(dp[i + 1][j], dp[i][j + 1]);  // Choose min of right and down
                dp[i][j] = Math.max(1, minHealthNext - dungeon[i][j]);     // Calculate min health needed here
            }
        }
        
        return dp[0][0];   // Minimum initial health required at the start (top-left)
    }
}
