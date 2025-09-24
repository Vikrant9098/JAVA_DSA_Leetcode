import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // If numerator is 0, the result is always "0"
        if (numerator == 0) return "0";
        
        // To build the result string
        StringBuilder result = new StringBuilder();
        
        // Check if result should be negative
        if ((numerator < 0) ^ (denominator < 0)) { // XOR → true if only one is negative
            result.append("-");
        }
        
        // Convert numerator and denominator to long (to avoid overflow for -2^31)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Append the integer part of division
        result.append(num / den);
        
        // Find remainder after integer division
        long remainder = num % den;
        
        // If no remainder, return result (it's a whole number)
        if (remainder == 0) {
            return result.toString();
        }
        
        // Otherwise, we have a fractional part → add decimal point
        result.append(".");
        
        // Map to store remainder → position in result string
        // Used to detect repeating decimals
        Map<Long, Integer> map = new HashMap<>();
        
        // Process fractional part until remainder becomes 0 or repeats
        while (remainder != 0) {
            // If this remainder already appeared → repeating decimal found
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);   // index where repeat started
                result.insert(pos, "(");        // put "(" at start of repeating part
                result.append(")");             // put ")" at end
                break;                          // stop, since repeat found
            }
            
            // Store remainder with its position in result string
            map.put(remainder, result.length());
            
            // Multiply remainder by 10 for next digit
            remainder *= 10;
            
            // Append the quotient digit after dividing by denominator
            result.append(remainder / den);
            
            // Update remainder
            remainder %= den;
        }
        
        // Return final result string
        return result.toString();
    }
}
