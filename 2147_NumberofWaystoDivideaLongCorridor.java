public class Solution {                     // Define the Solution class
    public int numberOfWays(String corridor) { // Method to count valid ways
        final int MOD = 1000000007;          // Mod value to avoid overflow

        int zero = 0;                        // Ways with 0 seats in current section
        int one = 0;                         // Ways with 1 seat in current section
        int two = 1;                         // Ways with 2 seats (valid section)

        for (char thing : corridor.toCharArray()) { // Loop through corridor characters
            if (thing == 'S') {              // If the character is a seat
                zero = one;                  // Move 1-seat ways to 0-seat
                int temp = one;              // Store old 1-seat value
                one = two;                   // Move 2-seat ways to 1-seat
                two = temp;                  // Move old 1-seat to 2-seat
            } else {                          // If the character is a plant
                two = (two + zero) % MOD;    // Add ways where a divider can be placed
            }
        }

        return zero;                         // Return total valid ways
    }
}
