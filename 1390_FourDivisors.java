class Solution { 
    // Main class containing the solution

    public int sumFourDivisors(int[] nums) { 
        // Method to calculate sum of divisors for numbers having exactly 4 divisors

        int res = 0; 
        // Stores the final result sum

        for(int num : nums){ 
            // Loop through each number in the array

            if(sumOne(num) != -1) 
                // Check if the number has exactly 4 divisors

                res += sumOne(num); 
                // Add the sum of its divisors to result
        }

        return res; 
        // Return total sum
    }

    private int sumOne(int n) { 
        // Method to return sum of divisors if n has exactly 4 divisors

        // Case 1: n = p³ (p is prime)
        int p = (int) Math.round(Math.cbrt(n)); 
        // Find cube root of n and convert to integer

        if ((long) p * p * p == n && isPrime(p)) { 
            // Check if n is exactly p³ and p is prime

            return 1 + p + p * p + p * p * p; 
            // Return sum of divisors: 1, p, p², p³
        }

        // Case 2: n = p × q (p and q are different primes)
        for (int i = 2; i * i <= n; i++) { 
            // Loop to find a divisor of n

            if (n % i == 0) { 
                // Check if i divides n

                int a = i; 
                // First divisor

                int b = n / i; 
                // Second divisor

                if (a != b && isPrime(a) && isPrime(b)) { 
                    // Check both divisors are different primes

                    return 1 + a + b + n; 
                    // Return sum of divisors: 1, a, b, n
                }

                return -1; 
                // If not valid, return -1
            }
        }
        return -1; 
        // Return -1 if no valid case found
    }

    private boolean isPrime(int x) { 
        // Method to check if a number is prime

        if (x < 2) return false; 
        // Numbers less than 2 are not prime

        for (int i = 2; i * i <= x; i++) { 
            // Loop from 2 to square root of x

            if (x % i == 0) return false; 
            // If divisible, not prime
        }

        return true; 
        // Number is prime
    }
}
