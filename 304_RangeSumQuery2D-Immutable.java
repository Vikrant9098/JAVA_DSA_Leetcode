class NumMatrix {

    private int[][] prefix; // to store prefix sum of the matrix

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;      // number of rows
        int n = matrix[0].length;   // number of columns
        prefix = new int[m + 1][n + 1]; // add extra row and column for easy math

        // build prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // current cell = value + top + left - overlap
                prefix[i][j] = matrix[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // use inclusion-exclusion to find sum in given area
        return prefix[row2 + 1][col2 + 1]   // total area
             - prefix[row1][col2 + 1]       // remove top part
             - prefix[row2 + 1][col1]       // remove left part
             + prefix[row1][col1];          // add overlap back
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
