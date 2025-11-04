class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // get number of rows and columns
        int m = matrix.length;
        int n = matrix[0].length;

        // memo array to store results of subproblems
        int[][] memo = new int[m][n];

        // directions to move: up, down, left, right
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // store the final maximum path length
        int maxLen = 0;

        // try starting DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // update max length from all cells
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo, dirs));
            }
        }

        // return the longest increasing path found
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo, int[][] dirs) {
        // if already computed, return it
        if (memo[i][j] != 0) return memo[i][j];

        // at least one cell (itself)
        int max = 1;

        // check all four directions
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            // move only if inside bounds and next cell is greater
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                && matrix[x][y] > matrix[i][j]) {

                // find length from the next cell
                int len = 1 + dfs(matrix, x, y, memo, dirs);

                // take the longer one
                max = Math.max(max, len);
            }
        }

        // save the result before returning
        memo[i][j] = max;

        // return longest path from this cell
        return max;
    }
}
