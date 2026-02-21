class Solution {
    
    // Function to count numbers whose set bits count is prime
    public int countPrimeSetBits(int left, int right) {
        
        int count = 0; // Stores final answer
        
        // Loop through all numbers from left to right (inclusive)
        for (int i = left; i <= right; i++) {
            
            // Count number of 1's in binary representation of i
            // Integer.bitCount(i) directly gives number of set bits
            int setBits = Integer.bitCount(i);
            
            // Check if the number of set bits is prime
            if (isPrime(setBits)) {
                count++; // If prime, increase count
            }
        }
        
        return count; // Return total count
    }
    
    
    // Helper function to check whether a number is prime
    private boolean isPrime(int n) {
        
        // Numbers <= 1 are not prime
        if (n <= 1) {
            return false;
        }
        
        // Check divisibility from 2 up to square root of n
        // If divisible by any number, it is not prime
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // Not prime
            }
        }
        
        return true; // If no divisors found, it is prime
    }
}