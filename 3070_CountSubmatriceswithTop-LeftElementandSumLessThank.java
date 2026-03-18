class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int row = grid.length;          // number of rows
        int col = grid[0].length;      // number of columns
        int res = 0;                   // result count

        for (int i = 0; i < row; i++) {        // iterate over rows
            for (int j = 0; j < col; j++) {    // iterate over columns

                if (i > 0)
                    grid[i][j] += grid[i - 1][j];   // add top prefix sum

                if (j > 0)
                    grid[i][j] += grid[i][j - 1];   // add left prefix sum

                if (i > 0 && j > 0)
                    grid[i][j] -= grid[i - 1][j - 1]; // remove double-counted area

                // now grid[i][j] stores sum of submatrix (0,0) to (i,j)

                if (grid[i][j] <= k)
                    res++;     // valid submatrix
                else
                    break;     // stop this row (further values will only increase)
            }
        }

        return res;   // total count
    }
}