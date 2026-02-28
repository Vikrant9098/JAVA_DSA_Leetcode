class Solution {

    public int concatenatedBinary(int n) {

        // Define modulo value (10^9 + 7) to prevent overflow and keep result within limits
        final long modulo = (long) (1e9 + 7);

        // This will store the final concatenated decimal value
        long result = 0;

        // This keeps track of number of binary digits required for current number
        int binaryDigits = 0;

        // Loop from 1 to n
        for (int i = 1; i <= n; i++) {

            // Check if i is a power of 2
            // (i & (i - 1)) == 0 works only for powers of 2
            // Whenever i is power of 2, number of binary digits increases by 1
            if ((i & (i - 1)) == 0) 
                binaryDigits++;

            // Left shift the previous result by number of binary digits of i
            // This makes space to append the binary form of i
            // Then add i to append it
            // Finally take modulo to avoid overflow
            result = ((result << binaryDigits) + i) % modulo;
        }

        // Convert long result to int and return
        return (int) result;
    }
}