class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        // create adjacency list for tree
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // fill adjacency list with edges
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);   // connect a -> b
            graph.get(e[1]).add(e[0]);   // connect b -> a (undirected)
        }

        // to mark visited nodes in dfs
        boolean[] visited = new boolean[n];

        // store number of cuts (components created)
        int[] count = new int[1];

        // start DFS from node 0
        dfs(0, graph, values, visited, k, count);

        // total components = cuts + 1 (root component)
        return count[0] + 1;
    }

    // DFS returns sum of subtree % k
    private long dfs(int node, List<List<Integer>> graph, int[] values,
                     boolean[] visited, int k, int[] count) {

        visited[node] = true;         // mark this node visited

        long sum = values[node];      // start sum with current node value

        // visit all neighbors
        for (int nei : graph.get(node)) {

            if (!visited[nei]) {      // if neighbor is not visited

                long childSum = dfs(nei, graph, values, visited, k, count); // get subtree sum

                if (childSum % k == 0) { // if child subtree sum is divisible by k
                    count[0]++;           // we can cut here → one more component
                } else {
                    sum += childSum;      // else add child's sum to parent
                }
            }
        }

        return sum % k; // return remainder to parent
    }
}
