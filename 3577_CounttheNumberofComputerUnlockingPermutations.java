class Solution {
    static final int MOD = 1_000_000_007;   // A large number used for modulo

    public int countPermutations(int[] comp) {
        int n = comp.length;                // Store the size of the array
        int first = comp[0];                // Store the first element

        // Check that first is the unique minimum
        for (int i = 1; i < n; i++) {       // Loop through the rest of the array
            if (comp[i] <= first) return 0; // If any element is <= first, no valid permutations
        }

        // Compute factorial (n-1)!
        long fact = 1;                      // Start factorial value
        for (int i = 2; i < n; i++) {       // Multiply from 2 to n-1
            fact = (fact * i) % MOD;        // Update factorial with modulo
        }

        return (int) fact;                  // Return the factorial result
    }
}
