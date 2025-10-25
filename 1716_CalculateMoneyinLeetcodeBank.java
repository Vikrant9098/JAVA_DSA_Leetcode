class Solution {
    public int totalMoney(int n) {
        int total = 0; // total amount saved
        int week = n / 7; // complete weeks
        int days = n % 7; // remaining days after full weeks

        // Sum for complete weeks
        // Each week starts 1 higher than the previous one
        for (int i = 0; i < week; i++) {
            // sum of each week = 7 * (first day of week) + (0+1+2+3+4+5+6)
            total += 7 * (1 + i) + 21; // 21 = sum of 0 to 6
        }

        // Sum for remaining days in the last incomplete week
        for (int i = 0; i < days; i++) {
            total += (week + 1) + i; // week + 1 is Monday value for this week
        }

        return total;
    }
}
