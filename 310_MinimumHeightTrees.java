import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // if only one node, that node is the answer
        if (n == 1) return Collections.singletonList(0);

        // create adjacency list to store graph connections
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashSet<>()); // initialize sets for each node

        // fill the graph with edges
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]); // connect node a to b
            graph.get(e[1]).add(e[0]); // connect node b to a (undirected)
        }

        // find all leaf nodes (nodes with only one connection)
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i); // add leaf
        }

        // keep removing leaves until 1 or 2 nodes remain
        while (n > 2) {
            n -= leaves.size(); // reduce total nodes count
            List<Integer> newLeaves = new ArrayList<>(); // store next round of leaves

            // process all current leaves
            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next(); // get connected node
                graph.get(neighbor).remove(leaf); // remove leaf from neighbor
                if (graph.get(neighbor).size() == 1) newLeaves.add(neighbor); // check if neighbor became a new leaf
            }

            // update leaves for next loop
            leaves = newLeaves;
        }

        // remaining 1 or 2 nodes are the centers (minimum height roots)
        return leaves;
    }
}
