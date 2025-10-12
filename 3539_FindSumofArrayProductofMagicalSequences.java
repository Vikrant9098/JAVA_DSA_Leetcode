class Solution {
    // Modulo constant and max factorial limit
    static final int MOD = 1_000_000_007, MAX = 31;

    // Arrays to store factorials and inverse factorials
    static final long[] FACT = new long[MAX], INV_FACT = new long[MAX];

    // Static block runs once to precompute factorials and inverse factorials
    static {
        FACT[0] = 1; // factorial of 0 = 1
        for (int i = 1; i < MAX; i++) 
            FACT[i] = FACT[i - 1] * i % MOD; // factorial with modulo

        INV_FACT[MAX - 1] = pow(FACT[MAX - 1], MOD - 2); // last inverse factorial using Fermat’s theorem

        // compute all inverse factorials backwards
        for (int i = MAX - 1; i > 0; i--) 
            INV_FACT[i - 1] = INV_FACT[i] * i % MOD;
    }

    // Function to compute (x^n) % MOD using fast exponentiation
    static long pow(long x, int n) {
        long res = 1; // start with 1
        for (; n > 0; n >>= 1, x = x * x % MOD) // square-and-multiply loop
            if ((n & 1) == 1) res = res * x % MOD; // multiply if current bit is 1
        return res; // return result
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length; // size of nums

        // Precompute powers of nums[i] up to m
        int[][] pows = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pows[i][0] = 1; // nums[i]^0 = 1
            for (int j = 1; j <= m; j++)
                pows[i][j] = (int) ((long) pows[i][j - 1] * nums[i] % MOD); // nums[i]^j mod MOD
        }

        // 4D memo table for DP: [index][mLeft][carry][kLeft]
        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];

        // Fill memo with -1 (uncomputed)
        for (int[][][] a : memo)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        // Call DFS and multiply by m! (since sequences can be permuted)
        return (int) (dfs(0, m, 0, k, pows, memo) * FACT[m] % MOD);
    }

    // DFS with memoization
    long dfs(int i, int mLeft, int carry, int kLeft, int[][] pows, int[][][][] memo) {
        int ones = Integer.bitCount(carry); // count 1-bits in carry

        // if not enough bits left to make k bits → stop
        if (ones + mLeft < kLeft) return 0;

        // if we used all nums → check valid base case
        if (i == pows.length) 
            return (mLeft == 0 && ones == kLeft) ? 1 : 0;

        // if result already computed → reuse
        if (memo[i][mLeft][carry][kLeft] != -1) 
            return memo[i][mLeft][carry][kLeft];

        long res = 0; // store total for this state

        // Try using j copies of nums[i]
        for (int j = 0; j <= mLeft; j++) {
            int bit = (carry + j) & 1; // current bit (0 or 1)
            if (bit <= kLeft) { // only proceed if valid for remaining k bits
                // move to next number, update carry and bits left
                long r = dfs(i + 1, mLeft - j, (carry + j) >> 1, kLeft - bit, pows, memo);

                // add contribution: r * nums[i]^j / j!
                res = (res + r * pows[i][j] % MOD * INV_FACT[j]) % MOD;
            }
        }

        // store in memo and return
        return memo[i][mLeft][carry][kLeft] = (int) res;
    }
}
