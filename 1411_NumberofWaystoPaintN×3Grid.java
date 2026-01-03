class Solution {                          // Defines the Solution class
    static final int MOD = 1000000007;    // Constant to avoid integer overflow

    public int numOfWays(int n) {         // Method to calculate number of ways for n rows
        long[] a = new long[n];           // Array to store ways where current row has 2 colors
        long[] b = new long[n];           // Array to store ways where current row has 3 colors

        a[0] = 6;                         // 6 ways to color first row using 2 colors
        b[0] = 6;                         // 6 ways to color first row using 3 colors

        for (int i = 1; i < n; i++) {     // Loop through each row from second to nth
            a[i] = (2 * a[i - 1] + 2 * b[i - 1]) % MOD; // Calculate 2-color patterns
            b[i] = (2 * a[i - 1] + 3 * b[i - 1]) % MOD; // Calculate 3-color patterns
        }

        return (int)((a[n - 1] + b[n - 1]) % MOD); // Return total ways for nth row
    }
}
