class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0; // total number of flips needed

        // loop through all 32 bits of integers (since max value < 2^31)
        for (int i = 0; i < 32; i++) {
            
            // extract the i-th bit of a using bitwise shift and AND
            int abit = (a >> i) & 1;

            // extract the i-th bit of b
            int bbit = (b >> i) & 1;

            // extract the i-th bit of c
            int cbit = (c >> i) & 1;

            // check if current bits of (a OR b) do not match c's bit
            if ((abit | bbit) != cbit) {
                
                if (cbit == 1) {
                    // if c has 1 but both a and b have 0 → need 1 flip
                    flips += 1;
                } else {
                    // if c has 0, we must flip every 1 in a and b
                    flips += abit + bbit; // add 1 for each 1-bit found
                }
            }
        }

        // return the total number of flips needed
        return flips;
    }
}
