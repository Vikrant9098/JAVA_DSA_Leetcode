class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending with 0 (except 0 itself) can't be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;  // directly return false
        }
        
        int reversedHalf = 0;  // to store the reversed half of the number
        
        // Keep reversing the last digits until we reach the middle
        while (x > reversedHalf) {
            int digit = x % 10;                     // get the last digit
            reversedHalf = reversedHalf * 10 + digit; // add digit to reversed half
            x /= 10;                                // remove the last digit from x
        }
        
        // If number has even digits: both halves will be equal
        // If number has odd digits: ignore the middle digit by dividing reversedHalf by 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
