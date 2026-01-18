class Solution {                                      // Define the Solution class
    public int largestMagicSquare(int[][] grid) {    // Method to find largest magic square
        
        int n = grid.length;                          // Number of rows in the grid
        int m = grid[0].length;                       // Number of columns in the grid
        
        long[][] rowPrefix = new long[n][m + 1];      // Prefix sum for rows
        long[][] colPrefix = new long[n + 1][m];      // Prefix sum for columns
        
        for (int i = 0; i < n; i++) {                 // Loop through each row
            for (int j = 0; j < m; j++) {             // Loop through each column
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                                                       // Store cumulative row sum
            }
        }
        
        for (int j = 0; j < m; j++) {                 // Loop through each column
            for (int i = 0; i < n; i++) {             // Loop through each row
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
                                                       // Store cumulative column sum
            }
        }
        
        for (int k = Math.min(n, m); k > 1; k--) {    // Try square sizes from largest to 2
            for (int r = 0; r <= n - k; r++) {        // Top row of the square
                for (int c = 0; c <= m - k; c++) {    // Left column of the square
                    
                    long target = rowPrefix[r][c + k] - rowPrefix[r][c];
                                                       // Sum of the first row (target sum)
                    boolean isMagic = true;            // Assume square is magic
                    
                    for (int i = 0; i < k; i++) {     // Check all row sums
                        long currRowSum =
                            rowPrefix[r + i][c + k] - rowPrefix[r + i][c];
                                                       // Current row sum
                        if (currRowSum != target) {   // Row sum mismatch
                            isMagic = false;          // Not a magic square
                            break;                    // Stop checking rows
                        }
                    }
                    if (!isMagic) continue;           // Skip this square
                
                    for (int j = 0; j < k; j++) {     // Check all column sums
                        long currColSum =
                            colPrefix[r + k][c + j] - colPrefix[r][c + j];
                                                       // Current column sum
                        if (currColSum != target) {   // Column sum mismatch
                            isMagic = false;          // Not a magic square
                            break;                    // Stop checking columns
                        }
                    }
                    if (!isMagic) continue;           // Skip this square
                    
                    long d1 = 0, d2 = 0;              // Diagonal sums
                    for (int i = 0; i < k; i++) {     // Loop through diagonals
                        d1 += grid[r + i][c + i];     // Main diagonal sum
                        d2 += grid[r + i][c + k - 1 - i];
                                                       // Anti-diagonal sum
                    }
                    
                    if (d1 == target && d2 == target) {
                                                       // If both diagonals match
                        return k;                     // Largest magic square found
                    }
                }
            }
        }
        
        return 1;                                     // Minimum magic square size
    }
}
