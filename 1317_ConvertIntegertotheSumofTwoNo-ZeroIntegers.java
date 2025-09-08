class Solution {
    public int[] getNoZeroIntegers(int n) {
        // Try all possible values of a from 1 to n-1
        for (int a = 1; a < n; a++) {
            int b = n - a; // b is the remaining part so that a + b = n
            // Check if both a and b are no-zero integers
            if (isNoZero(a) && isNoZero(b)) {
                return new int[]{a, b}; // return the pair if valid
            }
        }
        return new int[]{}; // This will never happen because solution always exists
    }

    // Function to check if a number has no zero in its digits
    private boolean isNoZero(int num) {
        while (num > 0) {        // check each digit of the number
            if (num % 10 == 0) { // if the last digit is 0
                return false;    // not a valid number
            }
            num /= 10;           // remove the last digit and continue
        }
        return true;             // return true if no digit was zero
    }
}
