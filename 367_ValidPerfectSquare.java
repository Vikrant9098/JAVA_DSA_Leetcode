class Solution {
    public boolean isPerfectSquare(int num) {
        // Use binary search to find if a number is a perfect square
        long left = 1;             // start from 1
        long right = num;          // end at num

        while (left <= right) {
            long mid = left + (right - left) / 2;  // find middle value
            long square = mid * mid;               // calculate mid^2

            if (square == num) {                   // if perfect square found
                return true;
            } else if (square < num) {             // if mid^2 is less, go right
                left = mid + 1;
            } else {                               // if mid^2 is more, go left
                right = mid - 1;
            }
        }

        return false;                              // not a perfect square
    }
}
