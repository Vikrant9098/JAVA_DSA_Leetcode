class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width ascending
        // If widths are same, sort by height descending
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));
        
        // Create an array to store only heights
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1]; // Extract height from each envelope
        }
        
        // Find Longest Increasing Subsequence (LIS) of heights
        return getLIS(heights);
    }
    
    private int getLIS(int[] nums) {
        // dp[i] stores smallest ending value of LIS of length i+1
        int[] dp = new int[nums.length];
        int len = 0; // Length of current LIS
        
        // Traverse each number
        for (int num : nums) {
            // Binary search in dp to find correct position for num
            int index = Arrays.binarySearch(dp, 0, len, num);
            
            // If not found, binarySearch returns negative position
            if (index < 0) {
                index = -(index + 1); // Convert to correct insert position
            }
            
            // Place num at found position
            dp[index] = num;
            
            // If num extends LIS, increase length
            if (index == len)
                len++;
        }
        
        // Return final LIS length
        return len;
    }
}
