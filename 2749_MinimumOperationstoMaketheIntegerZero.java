class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try k operations from 1 to 60
        for (int k = 1; k <= 60; k++) {
            // Calculate S = num1 - k * num2 (long used to prevent overflow)
            long S = (long) num1 - (long) k * (long) num2; 
            
            // If S is negative, check further
            if (S < 0) {
                // If num2 is positive, S will keep decreasing, so break loop
                if (num2 > 0) break;
                // If num2 is negative, maybe later S becomes valid, so continue
                else continue;
            }
            
            // Count number of set bits (1s) in binary of S
            int bits = Long.bitCount(S);
            
            // Check if S can be formed with exactly k terms:
            // (1) bits <= k (enough terms to represent S)
            // (2) k <= S (minimum sum of k terms is at least k)
            if (bits <= k && k <= S) return k;
        }
        
        // If no valid k found, return -1
        return -1;
    }
}
