class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; // Get the size of the square matrix
        
        // Step 1: Transpose the matrix
        // Swap elements matrix[i][j] with matrix[j][i] for all i < j
        for (int i = 0; i < n; i++) {           // Iterate over each row
            for (int j = i + 1; j < n; j++) {   // Iterate over each column starting from i+1 to avoid double swap
                int temp = matrix[i][j];        // Store the value at matrix[i][j] temporarily
                matrix[i][j] = matrix[j][i];    // Swap: assign value at matrix[j][i] to matrix[i][j]
                matrix[j][i] = temp;            // Complete the swap by assigning temp to matrix[j][i]
            }
        }

        // Step 2: Reverse each row to complete the 90° clockwise rotation
        for (int i = 0; i < n; i++) {           // Iterate over each row
            for (int j = 0; j < n / 2; j++) {   // Swap elements symmetrically from start and end of the row
                int temp = matrix[i][j];        // Store the left element temporarily
                matrix[i][j] = matrix[i][n - j - 1]; // Assign right element to left position
                matrix[i][n - j - 1] = temp;    // Assign temp (original left element) to right position
            }
        }
    }
}
