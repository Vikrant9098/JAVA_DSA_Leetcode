class Solution {
    public double myPow(double x, int n) {
        // Handle negative powers
        long N = n; // use long to prevent overflow (especially when n = -2^31)
        if (N < 0) {
            x = 1 / x; // reciprocal for negative exponent
            N = -N;    // make exponent positive
        }

        double result = 1.0; // initialize result

        // Fast exponentiation loop
        while (N > 0) {
            if ((N % 2) == 1) { // if current bit is set (odd power)
                result *= x;    // multiply result by x
            }
            x *= x;             // square the base
            N /= 2;             // divide exponent by 2
        }

        // Return the final result
        return result;
    }
}
