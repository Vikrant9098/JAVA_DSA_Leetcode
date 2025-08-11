class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Decompose n into its powers of 2
        // Example: n = 15 -> powers = [1, 2, 4, 8]
        java.util.List<Integer> powersList = new java.util.ArrayList<>();
        for (int i = 0; i < 31; i++) { // n <= 1e9 < 2^30
            if ((n & (1 << i)) != 0) {
                powersList.add(1 << i);
            }
        }

        // Step 2: Build prefix product array
        int m = powersList.size();
        long[] prefix = new long[m];
        prefix[0] = powersList.get(0) % MOD;
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * powersList.get(i)) % MOD;
        }

        // Step 3: Answer each query using prefix products
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = (int) prefix[r];
            } else {
                ans[i] = (int) ((prefix[r] * modInverse(prefix[l - 1], MOD)) % MOD);
            }
        }

        return ans;
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }

    // Fast exponentiation
    private long modPow(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
