class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;  // get number of balloons
        
        // create new array with extra 1s at both ends
        int[] arr = new int[n + 2];
        arr[0] = 1;  // left boundary
        arr[n + 1] = 1;  // right boundary
        
        // copy original balloons into the new array
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        
        // dp[i][j] = max coins from bursting balloons between i and j
        int[][] dp = new int[n + 2][n + 2];
        
        // l = length of the range
        for (int l = 2; l < n + 2; l++) {
            // i = start of the range
            for (int i = 0; i < n + 2 - l; i++) {
                int j = i + l;  // j = end of the range
                
                // try bursting each balloon k between i and j
                for (int k = i + 1; k < j; k++) {
                    // coins gained = left coins + burst k + right coins
                    int coins = arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j];
                    
                    // store the maximum coins possible in dp[i][j]
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        
        // return the max coins for full range
        return dp[0][n + 1];
    }
}
