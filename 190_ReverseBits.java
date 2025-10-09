class Solution {
    public int reverseBits(int n) {
        int result = 0; // variable to store the reversed bits

        // iterate over all 32 bits
        for (int i = 0; i < 32; i++) {
            // shift result to left to make room for the next bit
            result <<= 1;
            // add the least significant bit of n to result
            result |= (n & 1);
            // shift n to right to process the next bit
            n >>= 1;
        }

        return result; // return the reversed bit integer
    }
}
