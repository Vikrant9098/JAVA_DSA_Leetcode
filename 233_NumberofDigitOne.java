class Solution {
    public int countDigitOne(int n) {
        int count = 0; // total count of 1s
        long factor = 1; // current digit position (ones, tens, hundreds, etc.)

        while (factor <= n) {
            long lower = n % factor; // digits to the right
            long curr = (n / factor) % 10; // current digit
            long higher = n / (factor * 10); // digits to the left

            if (curr == 0) {
                count += higher * factor; // no extra ones
            } else if (curr == 1) {
                count += higher * factor + lower + 1; // include partial count
            } else {
                count += (higher + 1) * factor; // full range count
            }

            factor *= 10; // move to next digit position
        }

        return count; // total number of 1s
    }
}
