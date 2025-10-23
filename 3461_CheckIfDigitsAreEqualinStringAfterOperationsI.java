class Solution {
    public boolean hasSameDigits(String s) {
        // Continue until the string has exactly 2 digits
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();
            
            // For each consecutive pair of digits
            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';       // Convert char to integer
                int b = s.charAt(i + 1) - '0';   // Convert next char to integer
                next.append((a + b) % 10);       // Append sum modulo 10
            }
            
            // Update s with the new sequence
            s = next.toString();
        }
        
        // Check if the final two digits are equal
        return s.charAt(0) == s.charAt(1);
    }
}
