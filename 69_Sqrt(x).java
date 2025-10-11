class Solution {
    public int mySqrt(int x) {
        // If x is 0 or 1, return x itself
        if (x < 2) return x;

        // Initialize binary search boundaries
        int left = 1;
        int right = x / 2;
        int ans = 0;

        // Perform binary search to find square root
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow
            long square = (long) mid * mid; // use long to prevent overflow

            if (square == x) {
                return mid; // perfect square
            } else if (square < x) {
                ans = mid; // store possible answer
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }

        // Return the floor of the square root
        return ans;
    }
}
