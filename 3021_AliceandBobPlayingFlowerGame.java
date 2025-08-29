class Solution {
    public long flowerGame(int n, int m) {
        // Count how many odd numbers are in the range [1, n]
        // Formula: (n + 1) / 2 → because if n is odd, extra odd comes in
        long oddN = (n + 1) / 2;

        // Count how many even numbers are in the range [1, n]
        // Formula: n / 2 → because half the numbers are even
        long evenN = n / 2;

        // Count how many odd numbers are in the range [1, m]
        long oddM = (m + 1) / 2;

        // Count how many even numbers are in the range [1, m]
        long evenM = m / 2;

        // Alice wins if the total flowers (x + y) is odd.
        // Possible winning pairs:
        //   1) x is odd, y is even → odd + even = odd
        //   2) x is even, y is odd → even + odd = odd
        // So, multiply counts for both cases and add them.
        return oddN * evenM + evenN * oddM;
    }
}
