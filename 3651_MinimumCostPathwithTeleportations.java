class Solution {

    // Function to find minimum cost to reach bottom-right with at most k teleports
    public int minCost(int[][] grid, int k) {

        // Number of rows
        int n = grid.length;

        // Number of columns
        int m = grid[0].length;

        // --------------------------------------------------
        // Step 1: Find the maximum value in the grid
        // Needed to size helper arrays (temp, best)
        // --------------------------------------------------
        int maxVal = 0;
        for (int[] row : grid) {          // Loop through each row
            for (int val : row) {         // Loop through each cell
                maxVal = Math.max(maxVal, val); // Track max value
            }
        }

        // --------------------------------------------------
        // dp[i][j] = minimum cost to go from cell (i, j)
        //            to destination (n-1, m-1)
        // --------------------------------------------------
        int[][] dp = new int[n][m];

        // --------------------------------------------------
        // temp[v] = minimum dp value among all cells
        //           whose grid value == v
        // Used for teleport optimization
        // --------------------------------------------------
        int[] temp = new int[maxVal + 1];

        // --------------------------------------------------
        // best[v] = minimum cost among all temp[0..v]
        // Prefix minimum array
        // --------------------------------------------------
        int[] best = new int[maxVal + 1];

        // Initialize temp array with large values
        Arrays.fill(temp, Integer.MAX_VALUE);

        // --------------------------------------------------
        // Base case:
        // Cost to reach destination from destination is 0
        // No cost because cost is paid when ENTERING a cell
        // --------------------------------------------------
        temp[grid[n - 1][m - 1]] = 0;

        // ==================================================
        // INITIALIZATION PHASE (k = 0, no teleports)
        // Only allowed moves: right or down
        // ==================================================
        for (int i = n - 1; i >= 0; i--) {      // Traverse rows bottom-up
            for (int j = m - 1; j >= 0; j--) {  // Traverse cols right-to-left

                // Skip destination cell
                if (i == n - 1 && j == m - 1) continue;

                // Cost if we move DOWN
                int down = (i + 1 < n)
                        ? dp[i + 1][j] + grid[i + 1][j]
                        : Integer.MAX_VALUE;

                // Cost if we move RIGHT
                int right = (j + 1 < m)
                        ? dp[i][j + 1] + grid[i][j + 1]
                        : Integer.MAX_VALUE;

                // Choose cheaper walking path
                dp[i][j] = Math.min(down, right);

                // Update best cost for this cell value
                if (dp[i][j] != Integer.MAX_VALUE) {
                    temp[grid[i][j]] =
                            Math.min(temp[grid[i][j]], dp[i][j]);
                }
            }
        }

        // ==================================================
        // TELEPORT PHASE (k > 0)
        // Each iteration allows one more teleport
        // ==================================================
        for (int x = 0; x < k; x++) {

            // ----------------------------------------------
            // Step 1: Build prefix minimum array
            // best[v] = min(temp[0..v])
            // ----------------------------------------------
            best[0] = temp[0];
            for (int v = 1; v <= maxVal; v++) {
                best[v] = Math.min(best[v - 1], temp[v]);
            }

            // ----------------------------------------------
            // Step 2: Recalculate dp using
            // walking + teleport options
            // ----------------------------------------------
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    // Skip destination cell
                    if (i == n - 1 && j == m - 1) continue;

                    // Normal DOWN move
                    int down = (i + 1 < n)
                            ? dp[i + 1][j] + grid[i + 1][j]
                            : Integer.MAX_VALUE;

                    // Normal RIGHT move
                    int right = (j + 1 < m)
                            ? dp[i][j + 1] + grid[i][j + 1]
                            : Integer.MAX_VALUE;

                    // Best cost using walking only
                    int walkCost = Math.min(down, right);

                    // Teleport:
                    // Jump to any cell with value <= current cell value
                    int teleportCost = best[grid[i][j]];

                    // Choose minimum of walking vs teleport
                    dp[i][j] = Math.min(walkCost, teleportCost);

                    // Update temp for next teleport iteration
                    if (dp[i][j] != Integer.MAX_VALUE) {
                        temp[grid[i][j]] =
                                Math.min(temp[grid[i][j]], dp[i][j]);
                    }
                }
            }
        }

        // Minimum cost from top-left cell
        return dp[0][0];
    }
}
