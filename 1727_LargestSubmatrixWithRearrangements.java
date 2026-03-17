import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Step 1: Convert matrix into "heights" of consecutive 1s (like histogram)
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    // add height from previous row
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int res = 0;

        // Step 2: For each row, treat it as histogram
        for (int i = 0; i < row; i++) {

            // Sort heights to maximize width (rearranging columns allowed)
            Arrays.sort(matrix[i]);

            // Step 3: Try each height as the minimum height of submatrix
            for (int j = 0; j < col; j++) {
                int height = matrix[i][j];     // current height
                int width = col - j;           // width = remaining columns

                // calculate area and update max
                res = Math.max(res, height * width);
            }
        }

        return res;        
    }
}