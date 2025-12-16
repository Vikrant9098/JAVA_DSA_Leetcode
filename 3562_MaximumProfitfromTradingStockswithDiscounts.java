class Solution {                         // Define Solution class

    private int[][][] dp;                // 3D DP array: node, budget, state
    private List<Integer> adList[];      // Adjacency list for hierarchy tree

    private int getCost(int node, int curCost, int rep) {   // Function to get best cost from a child

        int cost = 0;                    // Initialize cost variable

        if (rep == 0) {                  // If parent does not buy
            cost = Math.max(dp[node][curCost][0], dp[node][curCost][1]); // Choose best child option

        } else if (rep == 1) {           // If parent buys without discount
            cost = Math.max(dp[node][curCost][0], dp[node][curCost][2]); // Choose allowed child options

        } else {                         // If parent buys with discount
            cost = Math.max(             // Choose maximum of all valid options
                    dp[node][curCost][0], // Child does not buy
                    Math.max(dp[node][curCost][1], dp[node][curCost][2]) // Child buys normally or discounted
            );
        }

        return cost;                     // Return best cost
    }

    private void dfs(int v, int[] present, int[] future, int budget) { // DFS function

        if (budget <= 0) return;         // Stop if no budget left

        int profit = future[v] - present[v]; // Profit without discount

        int profitWithDiscount = future[v] - present[v] / 2; // Profit with discount

        List<Integer> childNodes = new ArrayList<>(); // Store child nodes

        int[] child = new int[3];        // Unused helper array

        for (int u : adList[v]) {        // Loop through children of v
            dfs(u, present, future, budget); // DFS call for child
            childNodes.add(u);           // Add child to list
        }

        int len = childNodes.size();     // Number of children

        for (int rep = 0; rep < 3; rep++) { // Loop through 3 states

            int[][] childDp = new int[len + 1][budget + 1]; // DP for merging children

            for (int l = 0; l < len; l++) { // Loop through children
                int node = childNodes.get(l); // Get child node

                for (int b = 0; b <= budget; b++) { // Loop through budget

                    childDp[l + 1][b] = Math.max(childDp[l + 1][b], childDp[l][b]); // Skip child

                    for (int cb = 0; cb <= budget; cb++) { // Loop child budget

                        if (b + cb <= budget) { // Check budget limit
                            childDp[l + 1][b + cb] = Math.max( // Update DP
                                    childDp[l + 1][b + cb],
                                    childDp[l][b] + getCost(node, cb, rep) // Add child cost
                            );
                        }
                    }
                }
            }

            for (int b = 0; b <= budget; b++) { // Loop through budget

                if (rep == 0) {                 // If skip current node
                    dp[v][b][0] = childDp[len][b]; // Store result

                } else if (rep == 1) {          // If buy normally
                    if (b - present[v] >= 0) { // Check budget
                        dp[v][b][1] = childDp[len][b - present[v]] + profit; // Update DP
                    }

                } else {                        // If buy with discount
                    if (b - present[v] / 2 >= 0) { // Check budget
                        dp[v][b][2] = childDp[len][b - present[v] / 2] + profitWithDiscount; // Update DP
                    }
                }
            }
        }
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) { // Main function

        dp = new int[n][budget + 1][3];  // Initialize DP array

        adList = new ArrayList[n];       // Initialize adjacency list array
        for (int i = 0; i < n; i++) {    // Loop through nodes
            adList[i] = new ArrayList<>(); // Initialize each list
        }

        for (int[] h : hierarchy) {      // Loop through hierarchy
            int u = h[0] - 1;             // Parent index
            int v = h[1] - 1;             // Child index
            adList[u].add(v);             // Add edge
        }

        dfs(0, present, future, budget); // Start DFS from root

        int solution = 0;                // Store final answer

        for (int i = 0; i <= budget; i++) { // Loop through budgets
            solution = Math.max(solution,  // Update answer
                    Math.max(dp[0][i][0], dp[0][i][1])); // Choose best state
        }

        return solution;                 // Return maximum profit
    }
}
