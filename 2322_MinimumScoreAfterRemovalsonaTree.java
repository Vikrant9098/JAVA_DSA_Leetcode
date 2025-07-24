class Solution {
    int[] xor; // Stores the XOR value of the subtree rooted at each node
    List<Integer>[] graph; // Adjacency list to represent the tree
    int totalXor; // Stores XOR of all node values in the entire tree

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length; // Total number of nodes
        xor = new int[n]; // Initialize xor array to store subtree XORs
        graph = new ArrayList[n]; // Initialize the graph with n nodes
        
        // Create an empty list for each node to hold its neighbors
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        // Build the undirected graph using given edges
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]); // Add neighbor to both nodes
            graph[edge[1]].add(edge[0]);
        }

        // Step 1: Perform DFS to compute subtree XORs and totalXor
        boolean[] visited = new boolean[n]; // Not needed here, but can be used in variations
        totalXor = dfs(0, -1, nums); // DFS from root (0) with parent -1 to compute all subtree XORs

        // Step 2: Perform DFS to store parent of each node (for ancestor checks later)
        int[] parent = new int[n];
        Arrays.fill(parent, -1); // Initially, set all parents to -1
        dfsParent(0, -1, parent); // Fill parent info for each node

        int minScore = Integer.MAX_VALUE; // Initialize minimum score to max possible

        // Try removing every possible pair of edges (corresponding to nodes i and j)
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = i;
                int b = j;

                // Case 1: If a is an ancestor of b
                if (isAncestor(parent, a, b)) {
                    int xor1 = xor[b]; // Subtree of b (deepest child)
                    int xor2 = xor[a] ^ xor[b]; // Remaining subtree under a
                    int xor3 = totalXor ^ xor[a]; // The rest of the tree
                    minScore = Math.min(minScore, getScore(xor1, xor2, xor3)); // Compute and update score
                }
                // Case 2: If b is an ancestor of a
                else if (isAncestor(parent, b, a)) {
                    int xor1 = xor[a]; // Subtree of a (deepest child)
                    int xor2 = xor[b] ^ xor[a]; // Remaining subtree under b
                    int xor3 = totalXor ^ xor[b]; // The rest of the tree
                    minScore = Math.min(minScore, getScore(xor1, xor2, xor3)); // Compute and update score
                }
                // Case 3: a and b are in different branches (independent subtrees)
                else {
                    int xor1 = xor[a]; // Subtree under a
                    int xor2 = xor[b]; // Subtree under b
                    int xor3 = totalXor ^ xor[a] ^ xor[b]; // Rest of the tree
                    minScore = Math.min(minScore, getScore(xor1, xor2, xor3)); // Compute and update score
                }
            }
        }
        
        return minScore; // Return the minimum possible score
    }

    // Helper method: DFS to calculate subtree XOR values
    private int dfs(int node, int parent, int[] nums) {
        xor[node] = nums[node]; // Start with the node’s value
        for (int neighbor : graph[node]) {
            if (neighbor != parent) { // Avoid going back to parent
                xor[node] ^= dfs(neighbor, node, nums); // Accumulate XOR of all children
            }
        }
        return xor[node]; // Return total XOR of subtree rooted at current node
    }

    // Helper method: DFS to store the parent of each node
    private void dfsParent(int node, int par, int[] parent) {
        parent[node] = par; // Store parent of current node
        for (int neighbor : graph[node]) {
            if (neighbor != par) { // Avoid going back to parent
                dfsParent(neighbor, node, parent); // Recursive DFS call
            }
        }
    }

    // Helper method: Checks if `u` is an ancestor of `v` using parent array
    private boolean isAncestor(int[] parent, int u, int v) {
        while (v != -1) {
            if (v == u) return true; // Found ancestor in the path
            v = parent[v]; // Move up to parent
        }
        return false; // Not found
    }

    // Helper method: Calculates score as max - min of the three XOR values
    private int getScore(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }
}
