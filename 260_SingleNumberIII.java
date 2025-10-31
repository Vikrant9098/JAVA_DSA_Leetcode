class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers to get xor = a ^ b (where a and b are the unique numbers)
        int xor = 0;
        for (int num : nums) {
            xor ^= num;  // XORing all elements cancels out the pairs and leaves a ^ b
        }

        // Step 2: Find a set bit (rightmost bit) in xor to separate the two unique numbers
        int diff = xor & (-xor);  // Isolates the rightmost set bit

        // Step 3: Divide numbers into two groups based on the set bit and XOR separately
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                a ^= num;  // Group 1
            } else {
                b ^= num;  // Group 2
            }
        }

        // Step 4: Return the two single numbers
        return new int[]{a, b};
    }
}
