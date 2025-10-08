class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get total number of rows
        int m = matrix.length;
        // Get total number of columns
        int n = matrix[0].length;

        // Left pointer at start of matrix (flattened)
        int left = 0;
        // Right pointer at end of matrix (flattened)
        int right = m * n - 1;

        // Run binary search
        while (left <= right) {
            // Find middle index
            int mid = left + (right - left) / 2;

            // Convert mid index to row index
            int row = mid / n;
            // Convert mid index to column index
            int col = mid % n;

            // If middle element equals target, found it
            if (matrix[row][col] == target) {
                return true;
            }
            // If middle element is smaller, move right
            else if (matrix[row][col] < target) {
                left = mid + 1;
            }
            // If middle element is bigger, move left
            else {
                right = mid - 1;
            }
        }

        // Target not found in matrix
        return false;
    }
}
