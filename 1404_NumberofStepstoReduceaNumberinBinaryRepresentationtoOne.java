class Solution {
    public int numSteps(String s) {
        
        int l = s.length() - 1;   // Start from the last character (rightmost bit)
        int carry = 0;           // This simulates carry when we add 1 to an odd number
        int count = 0;           // To count total steps required
        
        // We stop at index 0 because when only one digit remains (most significant bit),
        // the process ends when it becomes '1'
        while (l > 0) {
            
            // Convert current character ('0' or '1') to integer and add carry
            int currentBit = Character.getNumericValue(s.charAt(l)) + carry;
            
            // Case 1: currentBit == 0
            // Means: even number (0 + 0)
            // Operation: divide by 2 (one step)
            if (currentBit == 0) {
                carry = 0;       // No carry generated
                count++;         // One operation (divide by 2)
            
            // Case 2: currentBit == 2
            // Means: (1 + 1) → binary 10
            // Result is even, so divide by 2
            } else if (currentBit == 2) {
                carry = 1;       // Carry remains 1
                count++;         // One operation (divide by 2)
            
            // Case 3: currentBit == 1
            // Means number is odd
            // Steps:
            //   1) Add 1 (makes it even)
            //   2) Divide by 2
            } else {
                carry = 1;       // Adding 1 creates a carry
                count += 2;      // Two operations (add 1 + divide by 2)
            }
            
            l--;   // Move to next bit (left side)
        }
        
        // If carry is still 1 at the most significant bit,
        // it means an extra step is needed
        // Example: 111 + carry → becomes 1000
        if (carry == 1) {
            count++;   // One extra divide step
        }
        
        return count;  // Return total steps
    }
}