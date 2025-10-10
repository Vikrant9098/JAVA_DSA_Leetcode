class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;          // get the length of the array
        
        // Traverse the digits from the end (least significant digit)
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;           // increment digit if it's less than 9
                return digits;         // no carry, return result
            }
            digits[i] = 0;             // if digit is 9, set to 0 and carry over
        }
        
        // If all digits were 9, we need a new array with one extra digit
        int[] result = new int[n + 1]; // new array initialized with 0 by default
        result[0] = 1;                 // set first digit to 1
        return result;                  // return the new array
    }
}
