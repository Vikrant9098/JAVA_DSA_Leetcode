class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {

        int MOD = 1_000_000_007;

        // dp[i][j][0] -> ways using i zeros and j ones, ending with 0
        // dp[i][j][1] -> ways using i zeros and j ones, ending with 1
        long[][][] dp = new long[zero+1][one+1][2];

        // base case: only zeros (cannot exceed limit consecutive zeros)
        for(int i=1;i<=Math.min(zero,limit);i++)
            dp[i][0][0]=1;

        // base case: only ones (cannot exceed limit consecutive ones)
        for(int j=1;j<=Math.min(one,limit);j++)
            dp[0][j][1]=1;

        // fill DP table
        for(int i=1;i<=zero;i++)
        for(int j=1;j<=one;j++){

            // sequences that would create more than limit zeros
            long over0 = (i-limit>=1)?dp[i-limit-1][j][1]:0;

            // sequences that would create more than limit ones
            long over1 = (j-limit>=1)?dp[i][j-limit-1][0]:0;

            // add 0 at the end
            // previous element could be 0 or 1
            // subtract invalid sequences exceeding limit
            dp[i][j][0] =
            (dp[i-1][j][0]+dp[i-1][j][1]-over0+MOD)%MOD;

            // add 1 at the end
            // previous element could be 0 or 1
            // subtract invalid sequences exceeding limit
            dp[i][j][1] =
            (dp[i][j-1][0]+dp[i][j-1][1]-over1+MOD)%MOD;
        }

        // total arrays ending with 0 or 1
        return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
    }
}