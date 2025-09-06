class Solution {
    public long minOperations(int[][] queries) {
        long result = 0; // stores the final answer (sum of all queries)

        // Process each query [l, r]
        for (int[] q : queries) {
            int l = q[0], r = q[1]; // range boundaries

            // Get total steps needed for numbers in [l, r]
            long stepsRange = prefixSteps(r) - prefixSteps(l - 1);

            // Each operation handles 2 numbers, so divide by 2
            // Use (stepsRange + 1) / 2 to simulate ceiling division
            result += (stepsRange + 1) / 2;
        }
        return result; // return the total across all queries
    }

    // prefixSteps(n) = total steps needed for numbers from 1 to n
    private long prefixSteps(long n) {
        if (n <= 0) return 0; // no numbers, no steps

        long total = 0;  // total steps for [1, n]
        long base = 1;   // starting number of the current group (like 1, 4, 16, 64...)
        int step = 1;    // steps needed for current group

        // keep going until we've covered all numbers up to n
        while (base <= n) {
            long start = base;                 // start of this range
            long end = Math.min(n, base * 4 - 1); // end of this range (or n if smaller)
            long count = end - start + 1;      // how many numbers in this range

            total += count * step;             // add steps for all numbers in this range

            base *= 4;   // move to the next power-of-4 range
            step++;      // numbers in next range need 1 more step
        }
        return total; // return total steps for [1, n]
    }
}
