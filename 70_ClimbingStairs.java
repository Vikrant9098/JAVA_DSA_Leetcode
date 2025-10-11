class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; // base cases: 1 step -> 1 way, 2 steps -> 2 ways

        int first = 1;  // ways to reach step 1
        int second = 2; // ways to reach step 2
        int third = 0;  // ways to reach current step

        // Loop from step 3 to n
        for (int i = 3; i <= n; i++) {
            third = first + second; // ways to reach current step = sum of previous two steps
            first = second;         // shift first
            second = third;         // shift second
        }

        return third; // return ways to reach step n
    }
}
