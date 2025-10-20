class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];  // Create an empty n x n matrix
        int left = 0, right = n - 1;     // Set left and right boundaries
        int top = 0, bottom = n - 1;     // Set top and bottom boundaries
        int num = 1;                     // Start filling numbers from 1

        // Keep filling until all layers are done
        while (left <= right && top <= bottom) {
            // Fill the top row from left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;  // Place number and move to next
            }
            top++;  // Move top boundary down

            // Fill the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;  // Place number and move down
            }
            right--;  // Move right boundary left

            // Fill the bottom row from right to left
            if (top <= bottom) {  // Check if there is still a bottom row
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;  // Place number and move left
                }
                bottom--;  // Move bottom boundary up
            }

            // Fill the left column from bottom to top
            if (left <= right) {  // Check if there is still a left column
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;  // Place number and move up
                }
                left++;  // Move left boundary right
            }
        }

        return matrix;  // Return the completed spiral matrix
    }
}
