class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n]; // dp[i] = max energy starting from magician i
        int maxEnergy = Integer.MIN_VALUE; // to track the maximum total energy
        
        // Traverse from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // If jumping k steps ahead goes out of bounds, only take current energy
            if (i + k >= n) {
                dp[i] = energy[i];
            } else {
                // Otherwise, add current energy + best result from i+k
                dp[i] = energy[i] + dp[i + k];
            }
            // Update global maximum
            maxEnergy = Math.max(maxEnergy, dp[i]);
        }
        
        return maxEnergy;
    }
}
