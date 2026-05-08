import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // Maximum possible value of nums[i]
    private static final int MX = 1000001;

    // factors[i] will store all prime factors of number i
    private static final List<Integer>[] factors = new ArrayList[MX];

    // Static block to precompute prime factors for all numbers up to MX
    static {
        // Initialize list for each number
        for (int i = 0; i < MX; i++) 
            factors[i] = new ArrayList<>();

        // Sieve-like approach to fill prime factors
        for (int i = 2; i < MX; i++) {
            // If empty → i is a prime number
            if (factors[i].isEmpty()) {
                // Add this prime factor to all its multiples
                for (int j = i; j < MX; j += i) 
                    factors[j].add(i);
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;

        // Map: prime factor -> list of indices having that factor
        Map<Integer, List<Integer>> edges = new HashMap<>();

        // Build mapping only for numbers with exactly ONE prime factor
        for (int i = 0; i < n; i++) {
            int a = nums[i];

            // If number has only one prime factor (like prime or power of prime)
            if (factors[a].size() == 1) {
                edges.computeIfAbsent(a, k -> new ArrayList<>()).add(i);
            }
        }

        int res = 0; // Number of jumps (levels in BFS)

        // Track visited indices
        boolean[] seen = new boolean[n];
        seen[n - 1] = true; // Start from last index

        // BFS queue starting from last index
        List<Integer> q = new ArrayList<>();
        q.add(n - 1);

        // BFS loop
        while (true) {
            List<Integer> q2 = new ArrayList<>(); // Next level queue

            for (int i : q) {

                // If we reached index 0 → answer found
                if (i == 0) return res;

                // Move to left neighbor
                if (i > 0 && !seen[i - 1]) {
                    seen[i - 1] = true;
                    q2.add(i - 1);
                }

                // Move to right neighbor
                if (i < n - 1 && !seen[i + 1]) {
                    seen[i + 1] = true;
                    q2.add(i + 1);
                }

                // Jump using common prime factors
                for (int p : factors[nums[i]]) {

                    // If this prime factor exists in map
                    if (edges.containsKey(p)) {

                        // Visit all indices having this factor
                        for (int j : edges.get(p)) {
                            if (!seen[j]) {
                                seen[j] = true;
                                q2.add(j);
                            }
                        }

                        // Clear list to avoid repeated processing (optimization)
                        edges.get(p).clear();
                    }
                }
            }

            // Move to next level
            q = q2;
            res++; // Increase jump count
        }
    }
}