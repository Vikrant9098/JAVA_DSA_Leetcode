class Solution {
    public int maximum69Number (int num) {
        // Convert the number to a character array
        char[] digits = String.valueOf(num).toCharArray();
        
        // Traverse the digits and change the first '6' to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // Only one change allowed
            }
        }
        
        // Convert back to integer and return
        return Integer.parseInt(new String(digits));
    }
}
