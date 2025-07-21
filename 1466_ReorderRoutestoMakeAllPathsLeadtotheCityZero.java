import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // Create an adjacency list to represent the graph
        // We'll store each neighbor with a flag:
        // - 1 means edge goes from current -> neighbor (may need to reverse)
        // - 0 means edge goes from neighbor -> current (already in correct direction)
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];

            // from -> to (original direction, needs to be reversed)
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1});
            // to -> from (correct direction)
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0});
        }

        // Visited array to avoid cycles
        boolean[] visited = new boolean[n];
        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Start from city 0
        visited[0] = true;

        int changes = 0; // Count of edges that need to be reversed

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Current city

            // Visit all neighbors of current city
            for (int[] neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                int nextCity = neighbor[0];
                int needsChange = neighbor[1];

                // If this city hasn't been visited yet
                if (!visited[nextCity]) {
                    changes += needsChange;  // Increment if we need to reverse the edge
                    visited[nextCity] = true;
                    queue.add(nextCity);     // Add the next city to queue
                }
            }
        }

        return changes; // Return the total number of edges to reverse
    }
}
