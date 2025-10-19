class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();          // Length of input string
        int n = p.length();          // Length of pattern

        // dp[i][j] = true if first i chars of s match first j chars of p
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;             // Empty string matches empty pattern

        // Initialize first row: empty string vs pattern
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; // '*' can match empty sequence
            }
        }

        // Fill the dp table for all string and pattern positions
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1); // Current char in string
                char pc = p.charAt(j - 1); // Current char in pattern

                if (pc == sc || pc == '?') {     // If chars match or pattern is '?'
                    dp[i][j] = dp[i - 1][j - 1]; // Take diagonal value
                } else if (pc == '*') {          // If pattern is '*'
                    // '*' matches empty (dp[i][j-1]) or one/more chars (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n]; // Return final answer: does full string match full pattern
    }
}
