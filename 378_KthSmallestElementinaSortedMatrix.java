class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; // number of rows (and columns) in the matrix
        
        int left = matrix[0][0]; // smallest value in matrix (top-left)
        int right = matrix[n - 1][n - 1]; // largest value in matrix (bottom-right)
        
        // binary search between smallest and largest value
        while (left < right) {
            int mid = left + (right - left) / 2; // find middle value between left and right
            
            int count = countLessEqual(matrix, mid, n); // count numbers <= mid
            
            if (count < k) { 
                // if count is less than k, we need bigger numbers
                left = mid + 1; 
            } else {
                // otherwise, mid could be the kth smallest
                right = mid; 
            }
        }
        
        return left; // when left == right, that is the kth smallest number
    }

    // helper function to count numbers <= mid in the matrix
    private int countLessEqual(int[][] matrix, int mid, int n) {
        int count = 0; // total count of numbers <= mid
        int row = n - 1; // start from bottom-left corner
        int col = 0; // first column
        
        // move through matrix
        while (row >= 0 && col < n) { 
            if (matrix[row][col] <= mid) {
                // if current number <= mid,
                // then all numbers above it are also <= mid
                count += row + 1;
                col++; // move right to next column
            } else {
                // if current number > mid, move up to smaller numbers
                row--;
            }
        }
        return count; // return how many numbers are <= mid
    }
}
