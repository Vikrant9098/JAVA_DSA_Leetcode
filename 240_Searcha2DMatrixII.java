class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start from top-right corner
        int row = 0;
        int col = matrix[0].length - 1;

        // Loop until we are inside matrix bounds
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // found the target
            } else if (matrix[row][col] > target) {
                col--; // move left if current value is too big
            } else {
                row++; // move down if current value is too small
            }
        }

        // Target not found
        return false;
    }
}
