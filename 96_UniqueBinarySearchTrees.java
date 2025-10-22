class Solution {
    public int numTrees(int n) { // Function to count unique BSTs
        int[] dp = new int[n + 1]; // dp[i] = number of unique BSTs with i nodes
        dp[0] = 1; // Empty tree has 1 structure
        dp[1] = 1; // One node has 1 structure

        for (int i = 2; i <= n; i++) { // Calculate for each number of nodes
            for (int j = 1; j <= i; j++) { // Choose each node as root
                dp[i] += dp[j - 1] * dp[i - j]; // Left * Right combinations
            }
        }

        return dp[n]; // Return total number of unique BSTs
    }
}
