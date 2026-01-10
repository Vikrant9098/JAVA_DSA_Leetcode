class Solution {                          // Define the Solution class
    public int minimumDeleteSum(String s1, String s2) {   // Method to find minimum ASCII delete sum
        int m = s1.length();              // Length of first string
        int n = s2.length();              // Length of second string
        int[] dp = new int[n + 1];        // DP array to store minimum cost values

        for (int j = 1; j <= n; j++) {    // Loop through second string
            dp[j] = dp[j - 1] + s2.charAt(j - 1); // Add ASCII value of current char of s2
        }

        for (int i = 1; i <= m; i++) {    // Loop through first string
            int prev = dp[0];             // Store previous diagonal DP value
            dp[0] += s1.charAt(i - 1);    // Add ASCII value of current char of s1

            for (int j = 1; j <= n; j++) { // Loop through second string
                int temp = dp[j];         // Store current DP value before update

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // If characters match
                    dp[j] = prev;         // No deletion needed, take diagonal value
                } else {                  // If characters do not match
                    dp[j] = Math.min(     // Choose minimum delete cost
                        dp[j] + s1.charAt(i - 1),   // Delete char from s1
                        dp[j - 1] + s2.charAt(j - 1) // Delete char from s2
                    );
                }

                prev = temp;              // Update prev for next iteration
            }
        }

        return dp[n];                     // Return final minimum delete sum
    }
}
