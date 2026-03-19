class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[] sumX = new int[cols]; // stores cumulative count of 'X' column-wise
        int[] sumY = new int[cols]; // stores cumulative count of 'Y' column-wise

        int res = 0; // result: number of valid submatrices

        for (int i = 0; i < rows; i++) {
            int rx = 0, ry = 0; // running count of 'X' and 'Y' for current row

            for (int j = 0; j < cols; j++) {

                // update row-wise counts
                if (grid[i][j] == 'X') rx++;
                else if (grid[i][j] == 'Y') ry++;

                // add current row contribution to column prefix
                sumX[j] += rx;
                sumY[j] += ry;

                // check if submatrix (0,0) to (i,j) has equal X and Y (and at least one X)
                if (sumX[j] > 0 && sumX[j] == sumY[j]) res++;
            }
        }

        return res; // return total valid submatrices
    }
}