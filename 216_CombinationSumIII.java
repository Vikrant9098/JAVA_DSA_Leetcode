import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Result list to store all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Start the backtracking process from number 1
        backtrack(1, k, n, new ArrayList<>(), result);

        // Return all valid combinations found
        return result;
    }

    /**
     * Helper function for backtracking
     * @param start    current number to try (to ensure increasing order and avoid reuse)
     * @param k        how many numbers need to be selected
     * @param remaining target sum that needs to be achieved
     * @param path     current combination being built
     * @param result   list to store all valid combinations
     */
    private void backtrack(int start, int k, int remaining, List<Integer> path, List<List<Integer>> result) {
        // If the combination is of size k and the sum is exactly n, it's valid
        if (path.size() == k && remaining == 0) {
            result.add(new ArrayList<>(path)); // Add a copy of the current combination
            return;
        }

        // If the combination is too long or the sum exceeds n, stop exploring
        if (path.size() > k || remaining < 0) {
            return;
        }

        // Try all numbers from current 'start' to 9
        for (int i = start; i <= 9; i++) {
            // Add current number to the combination
            path.add(i);

            // Recurse with next number and reduced remaining sum
            backtrack(i + 1, k, remaining - i, path, result);

            // Backtrack: remove the last added number to try next possibility
            path.remove(path.size() - 1);
        }
    }
}
