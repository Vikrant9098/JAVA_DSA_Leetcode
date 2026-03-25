class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        // Get number of rows (m) and columns (n)
        int m = grid.length, n = grid[0].length;

        long total = 0; // To store total sum of all elements

        // Step 1: Calculate total sum of the grid
        for (int[] row : grid)              // Traverse each row
            for (int x : row)               // Traverse each element in row
                total += x;                 // Add element to total

        // Step 2: If total sum is odd, equal partition is impossible
        if ((total & 1) == 1) return false;

        long target = total / 2;  // Each part must have this sum
        long sum = 0;             // Running sum for checking partitions

        // Step 3: Try horizontal partition (cut between rows)
        for (int i = 0; i < m - 1; i++) {   // Iterate till second last row

            // Add all elements of current row to sum
            for (int j = 0; j < n; j++)
                sum += grid[i][j];

            // If current sum equals target, valid partition found
            if (sum == target) return true;
        }

        // Reset sum for vertical partition
        sum = 0;

        // Step 4: Try vertical partition (cut between columns)
        for (int j = 0; j < n - 1; j++) {   // Iterate till second last column

            // Add all elements of current column to sum
            for (int i = 0; i < m; i++)
                sum += grid[i][j];

            // If current sum equals target, valid partition found
            if (sum == target) return true;
        }

        // Step 5: If no valid partition found
        return false;
    }
}