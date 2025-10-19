class Solution {
    public int divide(int dividend, int divisor) {
        // If overflow case: -2147483648 / -1 = 2147483648 (out of range)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // return max 32-bit value
        }

        // Check if result should be negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both to long and take absolute value to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        // Store the final result
        long result = 0;

        // Keep subtracting divisor from dividend
        while (a >= b) {
            long temp = b;        // store current divisor value
            long multiple = 1;    // track how many times we subtracted

            // Double temp and multiple until temp becomes too large
            while (a >= (temp << 1)) {
                temp <<= 1;       // multiply temp by 2
                multiple <<= 1;   // multiply multiple by 2
            }

            a -= temp;            // subtract the largest found multiple
            result += multiple;   // add how many times we subtracted
        }

        // If negative is true, make result negative
        result = negative ? -result : result;

        // If result is greater than max int, clamp to max int
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        // If result is smaller than min int, clamp to min int
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        // Return result as int
        return (int) result;
    }
}
