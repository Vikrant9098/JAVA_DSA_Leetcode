class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;  // Total number of fruits and baskets

        boolean[] used = new boolean[n];  // Track if a basket is already used

        int unplaced = 0;  // Counter for unplaced fruits

        // Loop through each fruit type
        for (int i = 0; i < n; i++) {
            boolean placed = false;  // Flag to check if current fruit is placed

            // Try placing the fruit in the leftmost available basket
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    // If basket is unused and has enough capacity
                    used[j] = true;   // Mark this basket as used
                    placed = true;    // Mark the fruit as placed
                    break;            // Stop checking more baskets
                }
            }

            if (!placed) {
                // If fruit couldn't be placed in any basket
                unplaced++;  // Increase the count of unplaced fruits
            }
        }

        return unplaced;  // Return the number of unplaced fruit types
    }
}
