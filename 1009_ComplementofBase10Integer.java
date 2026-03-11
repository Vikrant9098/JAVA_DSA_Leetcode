class Solution {
    public int bitwiseComplement(int n) {
        int mask = n | 1;        // make mask at least 1 (handles case when n = 0)

        for (int i = 0; i <= 4; i++)
            mask |= mask >> (1 << i);   // spread highest 1-bit to fill all lower bits with 1s

        return n ^ mask;         // XOR with mask flips bits of n → gives complement
    }
}