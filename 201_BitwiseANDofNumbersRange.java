class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0; // count how many bits we shifted
        
        // Find the common prefix of left and right
        while (left < right) {
            left >>= 1;   // shift both numbers right
            right >>= 1;
            shift++;      // count the number of shifts
        }
        
        // Shift the common prefix back to its original position
        return left << shift;
    }
}
