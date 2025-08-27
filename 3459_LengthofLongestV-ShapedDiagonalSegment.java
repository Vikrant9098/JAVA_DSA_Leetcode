class Solution {
    private int n, m; // number of rows and columns in the grid
    private int[][] grid; // the input matrix
    private Integer[][][][] memo; 
    /*
       memoization table to store results:
       memo[row][col][dir][usedTurn] 
       - row, col = current cell
       - dir = current diagonal direction (0..3)
       - usedTurn = 0 if turn not used yet, 1 if already used
    */

    // 4 diagonal directions: ↘, ↙, ↖, ↗
    private final int[][] dirs = {
        {1, 1},   // ↘ (down-right)
        {1, -1},  // ↙ (down-left)
        {-1, -1}, // ↖ (up-left)
        {-1, 1}   // ↗ (up-right)
    };

    // clockwise turns mapping:
    // ↘→↙, ↙→↖, ↖→↗, ↗→↘
    private final int[] turn = {1, 2, 3, 0};

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        n = grid.length;    // total rows
        m = grid[0].length; // total columns

        // memoization array initialized with null
        memo = new Integer[n][m][4][2];

        int ans = 0; // stores the maximum segment length

        // Try starting from every cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // The V-shaped diagonal must start with 1
                if (grid[i][j] == 1) {
                    // Try all 4 diagonal directions from this starting point
                    for (int d = 0; d < 4; d++) {
                        // Start length is 1 (the '1' itself),
                        // Next expected number in the sequence is 2
                        ans = Math.max(ans, 1 + dfs(i, j, d, 0, 2));
                    }
                }
            }
        }
        return ans; // return longest found
    }

    // DFS with memoization to explore diagonals
    private int dfs(int r, int c, int dir, int usedTurn, int expect) {
        // If we already computed this state, return it
        if (memo[r][c][dir][usedTurn] != null) {
            return memo[r][c][dir][usedTurn];
        }

        int best = 0; // best length found from this state

        // Move in the current direction
        int nr = r + dirs[dir][0];
        int nc = c + dirs[dir][1];

        // If next cell in same direction is in bounds and matches expectation
        if (inBounds(nr, nc) && grid[nr][nc] == expect) {
            // The next expected value alternates between 2 and 0
            int nextExpect = (expect == 2 ? 0 : 2);
            best = Math.max(best, 1 + dfs(nr, nc, dir, usedTurn, nextExpect));
        }

        // If turn not used yet, try making one clockwise turn
        if (usedTurn == 0) {
            int ndir = turn[dir]; // new direction after clockwise turn
            int tr = r + dirs[ndir][0];
            int tc = c + dirs[ndir][1];

            // Check if after turn the next cell is valid and matches expectation
            if (inBounds(tr, tc) && grid[tr][tc] == expect) {
                int nextExpect = (expect == 2 ? 0 : 2);
                best = Math.max(best, 1 + dfs(tr, tc, ndir, 1, nextExpect));
            }
        }

        // Store result in memo and return
        return memo[r][c][dir][usedTurn] = best;
    }

    // Utility function to check if a cell is inside the grid
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
