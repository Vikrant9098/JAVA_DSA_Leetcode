class Solution {
    public int trailingZeroes(int n) {
        int count = 0;  // to store number of trailing zeros
        
        // Count the number of factors of 5 in n!
        while (n > 0) {
            n /= 5;      // divide n by 5
            count += n;  // add the quotient to count
        }
        
        return count;   // return total trailing zeros
    }
}
