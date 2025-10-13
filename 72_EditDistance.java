class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();  // length of word1
        int n = word2.length();  // length of word2

        // dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // fill base cases: converting to/from empty string
        for (int i = 0; i <= m; i++) dp[i][0] = i;  // delete all chars
        for (int j = 0; j <= n; j++) dp[0][j] = j;  // insert all chars

        // build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if characters match, no operation needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // else take min of insert, delete, replace
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(dp[i - 1][j], // delete
                                 dp[i][j - 1]) // insert
                    );
                }
            }
        }

        // answer at bottom-right cell
        return dp[m][n];
    }
}
