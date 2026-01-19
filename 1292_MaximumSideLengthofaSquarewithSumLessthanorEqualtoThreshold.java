class Solution {                          // Define Solution class

    private boolean isValid(int[][] pref, int k, int limit) { // Method to check valid k×k square

        int n = pref.length;              // Store number of rows
        int m = pref[0].length;           // Store number of columns

        for (int i = k - 1; i < n; i++) { // Loop over rows for bottom-right corner
            for (int j = k - 1; j < m; j++) { // Loop over columns for bottom-right corner

                int x1 = i - k + 1;       // Calculate top row of square
                int y1 = j - k + 1;       // Calculate left column of square

                int sum = pref[i][j];     // Initialize sum with bottom-right prefix

                if (x1 > 0)               // Check if square exceeds top boundary
                    sum -= pref[x1 - 1][j]; // Subtract upper rectangle sum

                if (y1 > 0)               // Check if square exceeds left boundary
                    sum -= pref[i][y1 - 1]; // Subtract left rectangle sum

                if (x1 > 0 && y1 > 0)     // Check overlapping area condition
                    sum += pref[x1 - 1][y1 - 1]; // Add back overlapping sum

                if (sum <= limit)         // Check if square sum is within limit
                    return true;          // Return true if valid square found
            }                             // End inner loop
        }                                 // End outer loop
        return false;                     // Return false if no valid square exists
    }                                     // End isValid method

    public int maxSideLength(int[][] mat, int threshold) { // Main function

        int n = mat.length;               // Store number of rows
        int m = mat[0].length;            // Store number of columns

        int[][] pref = new int[n][m];     // Create prefix sum matrix

        for (int i = 0; i < n; i++)       // Loop through rows
            System.arraycopy(mat[i], 0, pref[i], 0, m); // Copy row into prefix matrix

        for (int i = 0; i < n; i++)       // Loop through rows
            for (int j = 1; j < m; j++)   // Loop through columns starting from index 1
                pref[i][j] += pref[i][j - 1]; // Compute row-wise prefix sum

        for (int j = 0; j < m; j++)       // Loop through columns
            for (int i = 1; i < n; i++)   // Loop through rows starting from index 1
                pref[i][j] += pref[i - 1][j]; // Compute column-wise prefix sum

        int low = 1, high = Math.min(n, m); // Set binary search limits
        int ans = 0;                        // Initialize answer

        while (low <= high) {              // Start binary search loop

            int mid = (low + high) / 2;    // Calculate middle square size

            if (isValid(pref, mid, threshold)) { // Check if mid size is valid
                ans = mid;                 // Update answer
                low = mid + 1;             // Search for larger square
            } else {                       // If mid size is invalid
                high = mid - 1;            // Search for smaller square
            }                              // End else
        }                                  // End while loop

        return ans;                        // Return maximum valid side length
    }                                      // End maxSideLength method
}                                          // End Solution class
