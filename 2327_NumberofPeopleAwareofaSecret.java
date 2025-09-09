class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;

        // dp[i] = number of people who learn the secret on day i
        long[] dp = new long[n + 1];
        dp[1] = 1; // On day 1, one person learns the secret

        long share = 0; // Number of people available to share the secret

        for (int day = 2; day <= n; day++) {
            // People who become eligible to share the secret today
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }
            // People who forget the secret today (no longer can share)
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
            // New people learning the secret today
            dp[day] = share;
        }

        long result = 0;
        // Count all people who still remember the secret on day n
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % MOD;
            }
        }

        return (int) result;
    }
}
