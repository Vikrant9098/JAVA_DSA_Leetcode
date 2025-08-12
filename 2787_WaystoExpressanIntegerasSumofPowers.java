class Solution {
    private static final int MOD = 1000000007;
    private int[][] dp;
    private int[] powers;
    private int size;

    public int numberOfWays(int n, int x) {
        // Step 1: Precompute all possible powers <= n
        size = 0;
        powers = new int[301]; // at most 300 possible bases
        for (int base = 1; ; base++) {
            int val = (int) Math.pow(base, x);
            if (val > n) break;
            powers[size++] = val;
        }

        // Step 2: DP array, -1 means uncomputed
        dp = new int[size + 1][n + 1];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        // Step 3: Start DFS
        return dfs(0, n);
    }

    private int dfs(int idx, int remaining) {
        // Base cases
        if (remaining == 0) return 1; // found one valid way
        if (remaining < 0 || idx >= size) return 0; // invalid path

        // Memoization check
        if (dp[idx][remaining] != -1) return dp[idx][remaining];

        // Choice: skip current power OR include it
        int skip = dfs(idx + 1, remaining);
        int take = dfs(idx + 1, remaining - powers[idx]);

        return dp[idx][remaining] = (int) (((long) skip + take) % MOD);
    }
}
