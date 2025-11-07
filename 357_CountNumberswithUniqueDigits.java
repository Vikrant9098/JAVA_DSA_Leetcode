class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // if n is 0, only number 0 exists
        if (n == 0) return 1;

        // count for n = 1 (0 to 9 → 10 numbers)
        int count = 10;

        // first digit can be chosen in 9 ways (1–9)
        int unique = 9;

        // remaining 9 digits (0–9 except the first)
        int available = 9;

        // loop while more digits left and digits available
        while (n-- > 1 && available > 0) {
            // multiply with available digits for next place
            unique = unique * available;

            // add new unique numbers to total count
            count += unique;

            // decrease available digits
            available--;
        }

        // return total unique numbers count
        return count;
    }
}
