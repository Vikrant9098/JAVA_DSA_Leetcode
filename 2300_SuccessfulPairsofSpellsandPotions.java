import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort the potions array to enable binary search
        Arrays.sort(potions);

        // Get the number of spells
        int n = spells.length;

        // Get the number of potions
        int m = potions.length;

        // Array to store the count of successful pairs for each spell
        int[] result = new int[n];

        // Iterate through each spell
        for (int i = 0; i < n; i++) {
            // Current spell strength
            int spell = spells[i];

            // Binary search bounds
            int low = 0;
            int high = m - 1;

            // Variable to track the first valid index in potions
            int index = m;

            // Binary search to find the leftmost potion that forms a successful pair
            while (low <= high) {
                // Calculate mid index
                int mid = low + (high - low) / 2;

                // Calculate product and ensure no overflow using type casting
                long product = (long) spell * potions[mid];

                // If product is enough, try to find a smaller index
                if (product >= success) {
                    index = mid;
                    high = mid - 1;
                } else {
                    // If product is too small, search in right half
                    low = mid + 1;
                }
            }

            // Number of successful pairs = potions from index to end
            result[i] = m - index;
        }

        // Return final result array
        return result;
    }
}
