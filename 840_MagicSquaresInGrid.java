class Solution { 
    // Main class named Solution

    private boolean isMagicSquare(int[][] grid, int i, int j) {
        // Method to check if a 3x3 grid starting at (i, j) is a magic square

        boolean[] seen = new boolean[10];
        // Array to track numbers 1 to 9 already used

        for (int x = 0; x < 3; x++) {
            // Loop through rows of the 3x3 grid

            for (int y = 0; y < 3; y++) {
                // Loop through columns of the 3x3 grid

                int num = grid[i + x][j + y];
                // Get the current number from the grid

                if (num < 1 || num > 9 || seen[num]) return false;
                // Return false if number is not 1–9 or already seen

                seen[num] = true;
                // Mark the number as seen
            }
        }

        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        // Calculate the sum of the first row

        for (int x = 0; x < 3; x++) {
            // Loop through each row

            if (sum != grid[i + x][j] + grid[i + x][j + 1] + grid[i + x][j + 2]) 
                return false;
            // Return false if any row sum is different
        }

        for (int y = 0; y < 3; y++) {
            // Loop through each column

            if (sum != grid[i][j + y] + grid[i + 1][j + y] + grid[i + 2][j + y]) 
                return false;
            // Return false if any column sum is different
        }

        if (sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) return false;
        // Check main diagonal sum

        if (sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) return false;
        // Check second diagonal sum

        return true;
        // Return true if all conditions are satisfied
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        // Method to count total magic squares in the grid

        int count = 0;
        // Variable to store number of magic squares found

        int rows = grid.length;
        // Total number of rows in the grid

        int cols = grid[0].length;
        // Total number of columns in the grid

        for (int i = 0; i <= rows - 3; i++) {
            // Loop to move across rows for 3x3 grids

            for (int j = 0; j <= cols - 3; j++) {
                // Loop to move across columns for 3x3 grids

                if (isMagicSquare(grid, i, j)) {
                    // Check if current 3x3 grid is magic

                    count++;
                    // Increase count if it is magic
                }
            }
        }

        return count;
        // Return the final count of magic squares
    }
}
