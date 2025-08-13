class Solution {
    public boolean isPowerOfThree(int n) {
        // The largest power of 3 in int range is 3^19 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }
}
