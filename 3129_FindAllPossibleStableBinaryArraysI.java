class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {

        int MOD = 1000000007; // Mod value to avoid integer overflow

        // dp[z][o][0] -> number of ways to form array using z zeros and o ones
        //                 where the LAST element placed is 0
        // dp[z][o][1] -> number of ways to form array using z zeros and o ones
        //                 where the LAST element placed is 1
        long[][][] dp = new long[zero + 1][one + 1][2];


        // ---------------- BASE CASES ----------------

        // If we only place zeros and no ones:
        // We can place at most 'limit' consecutive zeros.
        // So arrays like: [0], [0,0], [0,0,0] ... up to limit are valid.
        for(int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;   // Only one way: all zeros
        }

        // If we only place ones and no zeros:
        // Similarly we can place at most 'limit' consecutive ones.
        for(int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;   // Only one way: all ones
        }


        // ---------------- DP TRANSITIONS ----------------

        for(int z = 1; z <= zero; z++) {
            for(int o = 1; o <= one; o++) {

                // ---- CASE 1: Place 0 at the END ----
                // We previously had z-1 zeros and o ones.
                // The previous element could be either 0 or 1.
                dp[z][o][0] = (dp[z-1][o][0] + dp[z-1][o][1]) % MOD;

                // But if we place more than 'limit' consecutive zeros,
                // that configuration becomes invalid.
                // We remove those invalid cases.
                if(z - limit - 1 >= 0) {

                    // subtract sequences where limit+1 zeros appear consecutively
                    // These sequences previously ended with 1 before the zero block
                    dp[z][o][0] = (dp[z][o][0] - dp[z-limit-1][o][1] + MOD) % MOD;
                }


                // ---- CASE 2: Place 1 at the END ----
                // We previously had z zeros and o-1 ones.
                // Previous element could be either 0 or 1.
                dp[z][o][1] = (dp[z][o-1][0] + dp[z][o-1][1]) % MOD;

                // Remove invalid cases where we exceed 'limit' consecutive ones
                if(o - limit - 1 >= 0) {

                    // subtract sequences where limit+1 ones appear consecutively
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o-limit-1][0] + MOD) % MOD;
                }
            }
        }

        // Final result:
        // valid arrays can end with either 0 or 1
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}