import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();  // stack to store previous results and signs
        int result = 0;   // current result
        int sign = 1;     // current sign (+1 or -1)
        int number = 0;   // current number being read
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                // build the current number
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                // add the last number with its sign
                result += sign * number;
                number = 0;
                sign = 1;  // update sign
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1; // update sign
            } else if (c == '(') {
                // push current result and sign to stack
                stack.push(result);
                stack.push(sign);
                // reset for new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // add last number before closing parenthesis
                result += sign * number;
                number = 0;
                // first pop sign, then pop previous result
                result *= stack.pop(); // multiply by sign before '('
                result += stack.pop(); // add result before '('
            } else if (c == ' ') {
                // skip spaces
                continue;
            }
        }
        
        // add the last number if any
        result += sign * number;
        return result;
    }
}
