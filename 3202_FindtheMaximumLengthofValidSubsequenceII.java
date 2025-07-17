class Solution {
    public int maximumLength(int[] nums, int k) {
        // For each remainder r and ending mod m:
        // dp[r][m] = max length of valid subsequence ending with mod m
        int[][] dp = new int[k][k];
        
        for (int num : nums) {
            int mod = num % k;
            
            // For each possible remainder r
            for (int r = 0; r < k; r++) {
                // To get remainder r: prevMod + mod ≡ r (mod k)
                // So prevMod ≡ r - mod (mod k)
                int prevMod = (r - mod + k) % k;
                
                // Update: max of current value or extending previous sequence
                dp[r][mod] = Math.max(dp[r][mod], dp[r][prevMod] + 1);
            }
        }
        
        // Find maximum value
        int maxLength = 0;
        for (int r = 0; r < k; r++) {
            for (int m = 0; m < k; m++) {
                maxLength = Math.max(maxLength, dp[r][m]);
            }
        }
        
        return maxLength;
    }
}