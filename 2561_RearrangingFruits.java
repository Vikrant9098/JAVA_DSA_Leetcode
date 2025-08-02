import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // TreeMap to store the frequency difference between basket1 and basket2 for each fruit cost
        Map<Integer, Integer> freq = new TreeMap<>();

        // Count each fruit's frequency in basket1
        for (int fruit : basket1) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        }

        // Subtract the frequency of each fruit in basket2
        for (int fruit : basket2) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);
        }

        // List to store half of the extra fruits that need to be swapped
        List<Integer> toSwap = new ArrayList<>();

        // Check if frequency differences are even; collect fruits to be swapped
        for (int key : freq.keySet()) {
            int val = freq.get(key);
            // If any frequency difference is odd, return -1 (not possible to make equal)
            if (val % 2 != 0) return -1;

            // Add abs(val) / 2 times into the toSwap list (because each swap handles 2 mismatched items)
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                toSwap.add(key);
            }
        }

        // Sort the fruits to be swapped so that we can use the smallest values first (greedy strategy)
        Collections.sort(toSwap);

        int n = toSwap.size();

        // If nothing to swap, baskets are already equal
        if (n == 0) return 0;

        // Find the minimum cost fruit in both baskets — used as a helper swap element
        int minElement = Math.min(
            Arrays.stream(basket1).min().getAsInt(),
            Arrays.stream(basket2).min().getAsInt()
        );

        long cost = 0;

        // Only need to swap first half of the toSwap list (second half has matching elements)
        for (int i = 0; i < n / 2; i++) {
            // Choose the cheaper between direct swap and double swap using the minimum fruit
            cost += Math.min(toSwap.get(i), 2 * minElement);
        }

        // Return the total minimal cost of all required swaps
        return cost;
    }
}
