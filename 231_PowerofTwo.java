class Solution {
    public boolean isPowerOfTwo(int n) {
        // Powers of two are always positive
        if (n <= 0) {
            return false;
        }

        // A power of two has exactly one bit set in its binary form
        // Example: 1 -> 0001, 2 -> 0010, 4 -> 0100, 8 -> 1000
        // n & (n - 1) will be 0 only for powers of two
        return (n & (n - 1)) == 0;
    }
}
