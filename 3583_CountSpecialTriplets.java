class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;      // Big number to avoid overflow
        final int MAXV = 100001;            // Maximum value limit for arrays
        int[] memo = new int[MAXV];         // Stores how many times each number appeared
        int[] duplets = new int[MAXV];      // Stores count of valid pairs forming double

        int res = 0;                        // Final count of triplets
        for (int number : nums) {           // Loop through each number in array
            res = (res + duplets[number]) % MOD;   // Add existing pairs that match current number

            int twon = number * 2;          // Calculate double of current number
            if (twon < MAXV) {              // Check if inside valid range
                duplets[twon] = (duplets[twon] + memo[twon]) % MOD;  // Update pair count for double
            }

            memo[number]++;                 // Mark that this number has appeared once more
        }
        return res;                         // Return final answer
    }
}
