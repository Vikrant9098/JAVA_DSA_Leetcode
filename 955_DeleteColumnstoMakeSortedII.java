class Solution { 
    // Solution class

    public int minDeletionSize(String[] strs) {
        // Function to find minimum columns to delete

        int n = strs.length;
        // Number of strings (rows)

        int m = strs[0].length();
        // Length of each string (columns)

        char[][] a = new char[n][];
        // 2D char array to store characters of all strings

        for (int i = 0; i < n; i++) {
            // Loop through each string
            a[i] = strs[i].toCharArray();
            // Convert string to char array
        }

        boolean[] resolved = new boolean[n - 1];
        // resolved[i] = true means
        // strs[i] is already smaller than strs[i+1]

        int unresolved = n - 1;
        // Number of row pairs whose order is not decided yet

        int deletions = 0;
        // Count of deleted columns

        for (int col = 0; col < m && unresolved > 0; col++) {
            // Traverse columns left to right

            boolean needDelete = false;
            // Flag to check if current column must be deleted

            for (int row = 0; row < n - 1; row++) {
                // Compare adjacent rows

                if (!resolved[row] && a[row][col] > a[row + 1][col]) {
                    // If order breaks for unresolved rows
                    needDelete = true;
                    // Mark column for deletion
                    break;
                    // Stop checking further
                }
            }

            if (needDelete) {
                // If column breaks lexicographical order
                deletions++;
                // Increase delete count
                continue;
                // Skip this column
            }

            for (int row = 0; row < n - 1; row++) {
                // Update resolved row pairs
                if (!resolved[row] && a[row][col] < a[row + 1][col]) {
                    // If order is fixed by this column
                    resolved[row] = true;
                    // Mark as resolved
                    unresolved--;
                    // Reduce unresolved count
                }
            }
        }

        return deletions;
        // Return total deleted columns
    }
}
