class Solution {
    public int integerBreak(int n) {
        // base cases
        if (n == 2) return 1;  // 1 + 1 = 1*1 = 1
        if (n == 3) return 2;  // 1 + 2 = 1*2 = 2

        int product = 1;       // to store final product

        // keep subtracting 3 to maximize product
        while (n > 4) {        // if greater than 4
            product *= 3;      // multiply by 3
            n -= 3;            // reduce n by 3
        }

        // multiply remaining n (2, 3, or 4)
        product *= n;

        return product;        // return maximum product
    }
}
