class Solution {
    public String intToRoman(int num) {
        // Create arrays for values and corresponding Roman symbols
        // Ordered from largest to smallest for greedy approach
        // Includes all basic symbols and subtractive forms
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        // StringBuilder for efficient string building
        StringBuilder roman = new StringBuilder();
        
        // Go through each value-symbol pair from largest to smallest
        for (int i = 0; i < values.length; i++) {
            // Keep using this symbol while the number is >= its value
            while (num >= values[i]) {
                roman.append(symbols[i]);  // Add the symbol to result
                num -= values[i];          // Subtract the value from number
            }
        }
        
        // Convert StringBuilder to String and return
        return roman.toString();
    }
}