class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];     // Array to store ugly numbers
        ugly[0] = 1;                 // First ugly number is always 1

        int i2 = 0, i3 = 0, i5 = 0;  // Pointers for multiples of 2, 3, and 5
        int next2 = 2, next3 = 3, next5 = 5;  // Next possible ugly numbers

        for (int i = 1; i < n; i++) {        // Generate ugly numbers from 2nd to nth
            int nextUgly = Math.min(next2, Math.min(next3, next5)); // Pick the smallest among 2,3,5
            ugly[i] = nextUgly;              // Store it in the array

            if (nextUgly == next2) {         // If chosen number was from 2's list
                i2++;                        // Move 2's pointer ahead
                next2 = ugly[i2] * 2;        // Update next multiple of 2
            }
            if (nextUgly == next3) {         // If chosen number was from 3's list
                i3++;                        // Move 3's pointer ahead
                next3 = ugly[i3] * 3;        // Update next multiple of 3
            }
            if (nextUgly == next5) {         // If chosen number was from 5's list
                i5++;                        // Move 5's pointer ahead
                next5 = ugly[i5] * 5;        // Update next multiple of 5
            }
        }

        return ugly[n - 1];                  // Return the nth ugly number
    }
}
