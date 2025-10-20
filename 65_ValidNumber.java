class Solution {
    public boolean isNumber(String s) {
        s = s.trim();  // Remove leading and trailing spaces
        boolean numSeen = false;   // To check if any digit is seen
        boolean dotSeen = false;   // To check if '.' is seen
        boolean eSeen = false;     // To check if 'e' or 'E' is seen

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  // Get current character

            if (Character.isDigit(c)) {
                numSeen = true;  // At least one digit exists
            } 
            else if (c == '.') {
                // Dot cannot appear after 'e' or appear twice
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } 
            else if (c == 'e' || c == 'E') {
                // 'e' must appear only once and after a number
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false;  // Reset for the exponent part
            } 
            else if (c == '+' || c == '-') {
                // '+' or '-' can only appear at start or just after 'e'/'E'
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } 
            else {
                // Any other character is invalid
                return false;
            }
        }

        return numSeen;  // Valid if we saw at least one digit in the end
    }
}
