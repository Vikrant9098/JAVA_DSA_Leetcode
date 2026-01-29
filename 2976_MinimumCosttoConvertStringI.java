import java.util.*; // Import all utility classes like List, ArrayList, PriorityQueue

class Solution { // Define Solution class

    private void dijkstra(int src, List<int[]>[] adj, int[] dist) { 
        // Dijkstra method to find minimum cost from src character

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Min-heap that sorts by cost (a[0])

        dist[src] = 0; 
        // Distance from source to itself is zero

        pq.offer(new int[]{0, src}); 
        // Add source node with cost 0 into priority queue

        while (!pq.isEmpty()) { 
            // Continue while queue is not empty

            int[] cur = pq.poll(); 
            // Remove the node with smallest cost

            int d = cur[0], u = cur[1]; 
            // d = current cost, u = current node

            if (d > dist[u]) continue; 
            // Ignore if we already found a better path

            for (int[] edge : adj[u]) { 
                // Traverse all neighbors of current node

                int v = edge[0], w = edge[1]; 
                // v = destination node, w = edge cost

                if (dist[v] > d + w) { 
                    // If a cheaper path is found

                    dist[v] = d + w; 
                    // Update minimum cost to reach v

                    pq.offer(new int[]{dist[v], v}); 
                    // Add updated cost and node to heap
                }
            }
        }
    }

    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {
        // Main function to compute total minimum cost

        if (source.length() != target.length()) return -1;
        // If source and target lengths differ, return -1

        List<int[]>[] adj = new ArrayList[26];
        // Create adjacency list for 26 characters

        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();
        // Initialize each adjacency list

        for (int i = 0; i < original.length; i++) {
            // Loop through conversion rules

            adj[original[i] - 'a']
                .add(new int[]{changed[i] - 'a', cost[i]});
            // Add edge: original → changed with given cost
        }

        int[][] dist = new int[26][26];
        // dist[i][j] stores min cost to convert i → j

        for (int i = 0; i < 26; i++) {
            // Loop for every character

            Arrays.fill(dist[i], Integer.MAX_VALUE);
            // Initialize all distances as infinity

            dijkstra(i, adj, dist[i]);
            // Run Dijkstra from character i
        }

        long ans = 0;
        // Variable to store final answer

        for (int i = 0; i < source.length(); i++) {
            // Loop through each character in source

            int u = source.charAt(i) - 'a';
            // Convert source character to index

            int v = target.charAt(i) - 'a';
            // Convert target character to index

            if (u == v) continue;
            // Skip if characters are same

            if (dist[u][v] == Integer.MAX_VALUE) return -1;
            // If conversion is impossible, return -1

            ans += dist[u][v];
            // Add conversion cost to answer
        }

        return ans;
        // Return total minimum cost
    }
}
