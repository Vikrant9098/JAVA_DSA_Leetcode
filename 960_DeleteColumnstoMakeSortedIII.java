import java.util.Arrays;

class Solution {
    // Solution class

    public int minDeletionSize(String[] strs) {
        // Function to find minimum columns to delete

        int n = strs[0].length(), m = strs.length;
        // n = number of columns
        // m = number of strings (rows)

        int[] dp = new int[n];
        // dp[i] stores the longest valid column sequence ending at column i

        Arrays.fill(dp, 1);
        // Every column is valid by itself

        for (int i = 1; i < n; i++) {
            // Loop through columns

            for (int j = 0; j < i; j++) {
                // Compare previous columns

                if (isValid(strs, j, i)) {
                    // Check if column j can come before column i
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // Update longest valid sequence
                }
            }
        }

        int max = 0;
        // Stores maximum valid column sequence length

        for (int val : dp) 
            max = Math.max(max, val);
            // Find the maximum value in dp

        return n - max;
        // Columns to delete = total columns - max valid columns
    }

    private boolean isValid(String[] strs, int j, int i) {
        // Checks if column j <= column i for all strings

        for (String s : strs) {
            // Loop through each string

            if (s.charAt(j) > s.charAt(i))
                // If order breaks for any string
                return false;
                // Not a valid column order
        }

        return true;
        // Columns j and i are valid for all strings
    }
}
