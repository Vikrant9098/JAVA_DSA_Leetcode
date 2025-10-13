class Solution { // Define the class Solution
    public boolean isInterleave(String s1, String s2, String s3) { // Function to check interleaving
        if (s1.length() + s2.length() != s3.length()) return false; // If total lengths don't match, return false

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1]; // Create DP table
        dp[0][0] = true; // Empty s1 and s2 make empty s3

        for (int j = 1; j <= s2.length(); j++) // Loop through s2
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1); // Fill first row using s2 chars

        for (int i = 1; i <= s1.length(); i++) // Loop through s1
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1); // Fill first column using s1 chars

        for (int i = 1; i <= s1.length(); i++) { // Loop through each char in s1
            for (int j = 1; j <= s2.length(); j++) { // Loop through each char in s2
                // Check if s3’s current char matches s1 or s2
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || // From top (use s1)
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));  // From left (use s2)
            } // End inner loop
        } // End outer loop

        return dp[s1.length()][s2.length()]; // Return final result from last cell
    } // End function
} // End class
