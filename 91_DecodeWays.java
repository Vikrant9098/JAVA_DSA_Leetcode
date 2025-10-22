class Solution {
    public int numDecodings(String s) { // Function to count number of ways to decode string
        int n = s.length(); // Get length of string
        if (n == 0 || s.charAt(0) == '0') return 0; // If string empty or starts with 0, not decodable

        int[] dp = new int[n + 1]; // DP array to store ways up to each index
        dp[0] = 1; // Base case: empty string has 1 way
        dp[1] = 1; // Single char (not '0') has 1 way

        for (int i = 2; i <= n; i++) { // Loop from 2 to n
            int oneDigit = s.charAt(i - 1) - '0'; // Take single digit
            int twoDigits = Integer.parseInt(s.substring(i - 2, i)); // Take two digits

            if (oneDigit >= 1) dp[i] += dp[i - 1]; // If valid single digit (1–9), add previous count
            if (twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2]; // If valid two digits (10–26), add count before two steps
        }

        return dp[n]; // Return total ways to decode full string
    }
}
