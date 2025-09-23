import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // Stack to keep track of expected closing brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket '('
            if (c == '(') {
                stack.push(')'); // Push the corresponding closing bracket
            } 
            // If the character is an opening bracket '{'
            else if (c == '{') {
                stack.push('}'); // Push the corresponding closing bracket
            } 
            // If the character is an opening bracket '['
            else if (c == '[') {
                stack.push(']'); // Push the corresponding closing bracket
            } 
            // If the character is a closing bracket
            else {
                // Check if the stack is empty or top of stack does not match the closing bracket
                if (stack.isEmpty() || stack.pop() != c) {
                    return false; // Invalid string, mismatch found
                }
            }
        }

        // After processing all characters, stack must be empty for a valid string
        return stack.isEmpty();
    }
}
