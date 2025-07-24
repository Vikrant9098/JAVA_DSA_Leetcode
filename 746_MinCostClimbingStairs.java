class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Get the total number of steps in the staircase
        int n = cost.length;

        // If there are only two steps, the minimum cost to reach the top
        // is simply the smaller cost of the two
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        // Initialize the minimum cost to reach step 0 and step 1
        int dp0 = cost[0]; // Cost to reach the 0th step
        int dp1 = cost[1]; // Cost to reach the 1st step

        // Starting from step 2, calculate the cost to reach each step
        for (int i = 2; i < n; i++) {
            // The cost to reach the current step is its own cost plus
            // the minimum of the costs to reach the two previous steps
            int current = cost[i] + Math.min(dp0, dp1);

            // Move the sliding window forward:
            // previous two values shift ahead
            dp0 = dp1;
            dp1 = current;
        }

        // You can reach the top from either of the last two steps
        return Math.min(dp0, dp1);
    }
}
