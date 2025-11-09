class Solution {
    private static final int MOD = 1337; // given modulus value to take remainder

    public int superPow(int a, int[] b) {
        // start recursion from the last digit of array b
        return helper(a % MOD, b, b.length - 1);
    }

    private int helper(int a, int[] b, int index) {
        // base case: if no digits left, return 1
        if (index < 0) return 1;

        // take the last digit from array b
        int lastDigit = b[index];

        // part1 = (a ^ lastDigit) % 1337
        int part1 = modPow(a, lastDigit);

        // recursively find (a ^ remaining_digits), then raise it to 10 and mod 1337
        int part2 = modPow(helper(a, b, index - 1), 10);

        // multiply both parts and again mod 1337 to keep result small
        return (part1 * part2) % MOD;
    }

    // function to calculate (x^n) % 1337
    private int modPow(int x, int n) {
        int result = 1; // start with result = 1
        x %= MOD;       // keep x within MOD range

        // multiply x 'n' times, each time take modulo
        for (int i = 0; i < n; i++) {
            result = (result * x) % MOD;
        }

        // return final (x^n) % MOD
        return result;
    }
}
