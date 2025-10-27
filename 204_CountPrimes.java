class Solution {
    public int countPrimes(int n) {
        // If n <= 2, there are no primes
        if (n <= 2) return 0;

        // Create a boolean array to track prime numbers
        boolean[] isPrime = new boolean[n];
        
        // Assume all numbers from 2 to n-1 are prime
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Use Sieve of Eratosthenes to find primes
        for (int i = 2; i * i < n; i++) {
            // If i is still marked as prime
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count how many numbers are still marked as prime
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        // Return the total prime count
        return count;
    }
}
