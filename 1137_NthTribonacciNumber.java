class Solution {
    public int tribonacci(int n) {
        // Base case: T0 = 0
        if (n == 0) return 0;

        // Base case: T1 = 1
        if (n == 1) return 1;

        // Base case: T2 = 1
        if (n == 2) return 1;

        // Initialize the first three tribonacci numbers
        int t0 = 0; // T0
        int t1 = 1; // T1
        int t2 = 1; // T2
        int t3 = 0; // This will hold the current Tn value in each iteration

        // Loop from 3 to n to calculate Tn iteratively
        for (int i = 3; i <= n; i++) {
            // Calculate Tn = Tn-1 + Tn-2 + Tn-3
            t3 = t0 + t1 + t2;

            // Move the window forward for the next iteration
            t0 = t1;     // Tn-3 becomes Tn-2
            t1 = t2;     // Tn-2 becomes Tn-1
            t2 = t3;     // Tn-1 becomes the current Tn
        }

        // Return the nth tribonacci number
        return t3;
    }
}
