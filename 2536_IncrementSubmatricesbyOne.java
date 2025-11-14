class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        // Create a difference matrix (one extra row & column)
        int[][] diff = new int[n + 1][n + 1];
        
        // Loop through each query
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3]; // extract values

            diff[r1][c1]++;          // mark start of +1 area
            diff[r2 + 1][c1]--;      // cancel effect below the block
            diff[r1][c2 + 1]--;      // cancel effect right of the block
            diff[r2 + 1][c2 + 1]++;  // fix extra removal
        }
        
        // Final matrix to store result
        int[][] mat = new int[n][n];

        // Build the final grid using prefix sum
        for (int i = 0; i < n; i++) {             // row loop
            for (int j = 0; j < n; j++) {         // column loop
                
                int above = i > 0 ? mat[i - 1][j] : 0;       // value from top
                int left = j > 0 ? mat[i][j - 1] : 0;        // value from left
                int diag = i > 0 && j > 0 ? mat[i - 1][j - 1] : 0; // diagonal fix
                
                mat[i][j] = diff[i][j] + above + left - diag; // prefix sum formula
            }
        }
        
        return mat; // return final matrix
    }
}
