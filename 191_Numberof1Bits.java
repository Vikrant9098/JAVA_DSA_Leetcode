class Solution {
    public int hammingWeight(int n) {
        int count = 0; // to store number of 1 bits
        
        // loop until all bits are processed
        while (n != 0) {
            count++;        // found a set bit
            n = n & (n - 1); // remove the rightmost set bit
        }
        
        return count; // return total number of set bits
    }
}
