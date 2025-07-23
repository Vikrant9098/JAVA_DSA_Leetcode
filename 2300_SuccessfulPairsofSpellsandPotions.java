import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort the potions array to apply binary search
        Arrays.sort(potions);

        // Store the number of spells
        int n = spells.length;

        // Store the number of potions
        int m = potions.length;

        // Result array to hold the count of successful pairs for each spell
        int[] result = new int[n];

        // Iterate through each spell
        for (int i = 0; i < n; i++) {
            int spell = spells[i;

            // Binary search bounds
            int low = 0;
            int high = m - 1;

            // This will store the first index of a valid potion
            int index = m;

            // Perform binary search
            while (low <= high) {
                int mid = low + (high - low) / 2;

                // Multiply spell and potions[mid] and compare with success
                long product = (long) spell * potions[mid];

                if (product >= success) {
                    // Valid pair found, try to find earlier index
                    index = mid;
                    high = mid - 1;
                } else {
                    // Too small, search right half
                    low = mid + 1;
                }
            }

            // The number of successful potions is from index to end => m - index
            result[i] = m - index;
        }

        // Return the result array
        return result;
    }
}
