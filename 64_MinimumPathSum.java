class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;       // number of rows
        int n = grid[0].length;    // number of columns

        // Update first row: can only come from left
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];  // accumulate sum
        }

        // Update first column: can only come from top
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];  // accumulate sum
        }

        // Update rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Take minimum of top or left + current cell
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // Return the minimum path sum at bottom-right corner
        return grid[m - 1][n - 1];
    }
}
