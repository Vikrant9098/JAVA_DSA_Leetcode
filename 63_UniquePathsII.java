class Solution {  // define the Solution class
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {  // define the method
        int width = obstacleGrid[0].length;   // get number of columns
        int[] dp = new int[width];            // create 1D DP array for current row
        dp[0] = 1;                            // starting cell has 1 path

        for (int[] row : obstacleGrid) {      // loop through each row in the grid
            for (int j = 0; j < width; j++) { // loop through each column in the row
                if (row[j] == 1)              // check if current cell is an obstacle
                    dp[j] = 0;                // obstacle → no paths
                else if (j > 0)               // if not first column
                    dp[j] += dp[j - 1];      // add paths from left cell
            }                                  // end of inner loop (columns)
        }                                      // end of outer loop (rows)

        return dp[width - 1];                 // return number of paths to bottom-right
    }                                          // end of method
}                                              // end of class
