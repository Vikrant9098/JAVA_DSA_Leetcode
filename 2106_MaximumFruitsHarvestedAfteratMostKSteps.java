class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length; // Total number of fruit positions
        int maxFruits = 0;     // Variable to store the maximum fruits collected
        int left = 0;          // Left pointer of the sliding window
        int total = 0;         // Sum of fruits in the current window

        // Loop through each fruit position using the right pointer
        for (int right = 0; right < n; right++) {
            total += fruits[right][1];  // Add the amount of fruits at current right position to total

            // Shrink the window from the left if it takes more than k steps to visit this window
            while (left <= right && !canReach(fruits, left, right, startPos, k)) {
                total -= fruits[left][1]; // Remove the fruits at the left position from total
                left++;                  // Move the left pointer one step to the right
            }

            // Update the maximum fruits harvested if current total is higher
            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits; // Return the maximum number of fruits we can collect
    }

    // This helper function checks if the player can reach the window [left, right] using at most k steps
    private boolean canReach(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];   // Get the x-position of the left end of the window
        int rightPos = fruits[right][0]; // Get the x-position of the right end of the window

        // Calculate total steps needed if we go left first, then right
        int steps1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);

        // Calculate total steps needed if we go right first, then left
        int steps2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        // Return true if any of the two ways can be done within k steps
        return Math.min(steps1, steps2) <= k;
    }
}
