class Solution {
    public int numDistinct(String s, String t) {
        // Get the lengths of both strings
        int m = s.length(), n = t.length();

        // Create a 2D DP array to store subproblem results
        // dp[i][j] means: number of ways to form t[0..j-1] from s[0..i-1]
        long[][] dp = new long[m + 1][n + 1];

        // Base case: an empty string t can always be formed from any prefix of s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {           // Loop over s
            for (int j = 1; j <= n; j++) {       // Loop over t
                // If characters match, we can either use or skip this character
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If they don't match, we skip the character from s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The last cell holds the total number of distinct subsequences
        return (int) dp[m][n];
    }
}
