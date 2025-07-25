class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();  // length of first string
        int n = text2.length();  // length of second string

        // dp[i][j] means LCS of text1[0..i-1] and text2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // loop through both strings
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if characters match, increase LCS length by 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // else take max from top or left
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // final answer is at bottom-right
        return dp[m][n];
    }
}
