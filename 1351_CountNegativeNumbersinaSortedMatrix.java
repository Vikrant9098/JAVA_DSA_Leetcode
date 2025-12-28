class Solution {                      // Define the Solution class
 public int countNegatives(int[][] grid) {   // Method to count negative numbers
        int rows = grid.length;        // Get total number of rows
        // int cols = grid[0].length;     // Get total number of columns
        int row = 0;                   // Start from first row
        int col = grid[0].length-1;    // Start from last column (top-right corner)
        int count = 0;                 // Store count of negative numbers

        while(row < rows && col >= 0){ // Loop while inside matrix bounds
            if(grid[row][col] >= 0){   // If current value is non-negative
                row++;                 // Move down to next row
            } else {                   // If current value is negative
                count += rows-row;     // Add all negatives below this cell
                col--;                 // Move left to previous column
            }
        }
        return count;                  // Return total negative count
    }
}
