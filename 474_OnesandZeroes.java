class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // Create DP array where dp[i][j] = max strings using i zeros and j ones
        int[][] dp = new int[m + 1][n + 1];
        
        // Loop through each binary string
        for (String s : strs) {
            // Count zeros and ones in current string
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;     // Count zero
                else ones++;               // Count one
            }

            // Update dp from bottom-right to avoid using same string twice
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    // Choose max of including or excluding this string
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        // Return max subset size that fits m zeros and n ones
        return dp[m][n];
    }
}
