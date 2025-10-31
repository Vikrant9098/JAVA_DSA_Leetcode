class Solution {
    public boolean isUgly(int n) {
        // Step 1: Negative numbers and 0 are not ugly
        if (n <= 0) return false;
        
        // Step 2: Divide n by 2, 3, and 5 as long as possible
        while (n % 2 == 0) n /= 2;  // Remove factor 2
        while (n % 3 == 0) n /= 3;  // Remove factor 3
        while (n % 5 == 0) n /= 5;  // Remove factor 5
        
        // Step 3: If n becomes 1, it has no other prime factors → ugly
        return n == 1;
    }
}
