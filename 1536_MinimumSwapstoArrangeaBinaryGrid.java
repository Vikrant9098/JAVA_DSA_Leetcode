class Solution {
    public int minSwaps(int[][] grid) {
        // Get size of grid (n x n)
        int n = grid.length;

        // Array to store number of trailing zeros for each row
        int[] zeros = new int[n];

        // Step 1: Count trailing zeros in each row
        for (int i = 0; i < n; i++) {
            int count = 0;

            // Start from last column and count consecutive zeros
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }

            // Store trailing zero count for current row
            zeros[i] = count;
        }

        // Variable to count total swaps
        int swaps = 0;

        // Step 2: Try to arrange rows one by one
        for (int i = 0; i < n; i++) {

            // For row i, we need at least (n - i - 1) trailing zeros
            // Because below diagonal elements must be zero
            int needed = n - i - 1;

            int j = i;

            // Find a row below (or same) that satisfies required trailing zeros
            while (j < n && zeros[j] < needed) 
                j++;

            // If no such row exists, arrangement is impossible
            if (j == n) 
                return -1;

            // Bring row j up to position i using adjacent swaps
            while (j > i) {
                // Swap zeros[j] with zeros[j - 1]
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;

                j--;
                swaps++;  // Count each adjacent swap
            }
        }

        // Return total swaps required
        return swaps;
    }
}