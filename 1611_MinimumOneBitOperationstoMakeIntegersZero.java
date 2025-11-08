class Solution {
    public int minimumOneBitOperations(int n) {
        // Call helper function to convert from Gray code to binary form
        return grayToBinary(n);
    }

    // Helper method to convert Gray code to binary
    private int grayToBinary(int n) {
        int res = n;          // Start with initial value of n
        while (n > 0) {       // Continue until all bits are processed
            n >>= 1;          // Right shift n by 1 bit
            res ^= n;         // XOR res with shifted n to update result
        }
        return res;           // Return final binary value (min operations)
    }
}
