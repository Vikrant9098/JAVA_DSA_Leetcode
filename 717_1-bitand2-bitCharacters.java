class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        
        int i = 0; // pointer to move through bits
        
        // iterate until second last bit
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2; // two-bit character (10 or 11)
            } else {
                i += 1; // one-bit character (0)
            }
        }
        
        // if pointer stops at last index, it's a one-bit character
        return i == bits.length - 1;
    }
}
