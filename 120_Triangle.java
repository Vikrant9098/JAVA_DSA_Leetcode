class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();  
        // Get the number of rows in the triangle

        int[] dp = new int[n];  
        // Create a dp array of size equal to the last row (stores min path sums)

        // Initialize dp with the last row values of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);  
            // Copy the last row into dp, since that's the base case
        }

        // Start from the second last row and move upward
        for (int row = n - 2; row >= 0; row--) {
            // For each element in the current row
            for (int col = 0; col <= row; col++) {
                // Update dp[col] with the minimum path sum from current element
                // Either move straight down (dp[col]) or diagonally right (dp[col + 1])
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // After processing all rows, dp[0] contains the min path sum from top to bottom
        return dp[0];
    }
}
