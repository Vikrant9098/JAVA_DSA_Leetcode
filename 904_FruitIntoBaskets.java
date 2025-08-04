import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        // Map to store the count of each fruit type in the current window
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0; // Stores the maximum number of fruits we can pick
        int left = 0; // Left boundary of the window

        // Iterate over each fruit in the array (right boundary of the window)
        for (int right = 0; right < fruits.length; right++) {
            // Add the fruit at the right pointer to the basket
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits, shrink the window from the left
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++; // Move the left pointer to shrink the window
            }

            // Update the maximum fruits picked
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
