class Solution {
    public int getSum(int a, int b) {
        // keep adding until there is no carry left
        while (b != 0) {
            int carry = (a & b) << 1; // find carry using AND, then shift left
            a = a ^ b;                // add without carry using XOR
            b = carry;                // assign carry for next iteration
        }
        return a; // final sum
    }
}
