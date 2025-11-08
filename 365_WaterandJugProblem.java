class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // If total capacity is less than target, impossible
        if (x + y < target) return false;

        // If target is 0, it's trivially possible
        if (target == 0) return true;

        // Use GCD logic: we can measure target if target is a multiple of gcd(x, y)
        return target % gcd(x, y) == 0;
    }

    // Helper method to find GCD (Greatest Common Divisor)
    private int gcd(int a, int b) {
        while (b != 0) {     // loop until remainder is zero
            int temp = b;    // store b temporarily
            b = a % b;       // remainder becomes new b
            a = temp;        // old b becomes new a
        }
        return a;            // return GCD
    }
}
