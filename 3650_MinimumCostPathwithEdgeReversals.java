import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int minCost(int n, int[][] edges) {

        // create adjacency list for graph
        ArrayList<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();     // initialize each list

        // add edges to the graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];            // start node
            int v = edges[i][1];            // end node
            int w = edges[i][2];            // edge cost

            adj[u].add(new int[]{v, w});        // forward edge
            adj[v].add(new int[]{u, 2 * w});    // reverse edge with double cost
        }

        // large value for infinity
        final int INF = 1000000000;

        int[] dist = new int[n];            // distance array

        for (int i = 0; i < n; i++)
            dist[i] = INF;                  // set all distances to INF

        dist[0] = 0;                        // start node distance is 0

        // priority queue for Dijkstra (min cost first)
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, 0});             // add start node (cost, node)

        while (!pq.isEmpty()) {              // run while queue not empty
            int[] cur = pq.poll();           // get min cost node
            int d = cur[0];                  // current cost
            int u = cur[1];                  // current node

            if (u == n - 1)                  // if destination reached
                return d;                    // return answer

            if (d != dist[u])                // ignore old value
                continue;

            for (int i = 0; i < adj[u].size(); i++) {
                int[] e = adj[u].get(i);     // get edge
                int v = e[0];                // neighbor node
                int w = e[1];                // edge cost

                if (dist[u] + w < dist[v]) { // if shorter path found
                    dist[v] = dist[u] + w;   // update distance
                    pq.add(new int[]{dist[v], v}); // push to queue
                }
            }
        }

        return -1;                           // destination not reachable
    }
}
