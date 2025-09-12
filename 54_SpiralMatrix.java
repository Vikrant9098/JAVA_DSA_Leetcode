import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // List to store the elements in spiral order
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if matrix is null or empty, return empty list
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        // Initialize the boundaries of the matrix
        int top = 0;                     // Top boundary of current layer
        int bottom = matrix.length - 1;  // Bottom boundary
        int left = 0;                    // Left boundary
        int right = matrix[0].length - 1;// Right boundary
        
        // Traverse the matrix layer by layer until boundaries overlap
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move top boundary down after traversing top row
            
            // Traverse from top to bottom along the rightmost column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move right boundary left after traversing right column
            
            // Traverse from right to left along the bottom row if still valid
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move bottom boundary up after traversing bottom row
            }
            
            // Traverse from bottom to top along the leftmost column if still valid
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move left boundary right after traversing left column
            }
        }
        
        // Return the final spiral order list
        return result;
    }
}
