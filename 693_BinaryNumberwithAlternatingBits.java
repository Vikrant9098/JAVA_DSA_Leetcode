class Solution {

    public boolean hasAlternatingBits(int n) {
        // Function to check whether binary representation of n has alternating bits (like 101010)

        int x = n ^ (n >> 1);
        // Shift n one bit to the right and XOR with original n
        // If bits are alternating, result x becomes all 1s (like 1111)

        return (x & (x + 1)) == 0;
        // Check if x is of the form 111... (all 1s)
        // For such numbers, x & (x + 1) becomes 0
        // If true → n has alternating bits, else false
    }
}
