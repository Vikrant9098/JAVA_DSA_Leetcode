class Solution {
    public boolean isPowerOfFour(int n) {
        // Check 1: n must be positive
        // Check 2: n must be a power of two (only one bit set)
        // Check 3: The only set bit must be in an odd position (1, 4, 16, ...)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
