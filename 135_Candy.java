class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;          // Number of children in the line
        int[] candies = new int[n];      // Array to store number of candies for each child

        // Step 1: Initialize each child with at least 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;              // Every child gets at least one candy
        }

        // Step 2: Left to right pass
        // Ensure children with higher rating than left neighbor get more candies
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;  // Give one more candy than left neighbor
            }
        }

        // Step 3: Right to left pass
        // Ensure children with higher rating than right neighbor get more candies
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Take the maximum: either existing candies or one more than right neighbor
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Sum up all candies to get the minimum total required
        int total = 0;                    // Initialize total candies
        for (int i = 0; i < n; i++) {
            total += candies[i];          // Add candies of each child
        }

        return total;                     // Return the total minimum candies needed
    }
}
