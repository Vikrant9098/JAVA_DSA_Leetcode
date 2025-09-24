import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        // Stack to store numbers during evaluation
        Stack<Integer> stack = new Stack<>();
        
        // Loop through each token in the input
        for (String token : tokens) {
            // If the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop the second operand from stack
                int b = stack.pop();
                // Pop the first operand from stack
                int a = stack.pop();
                // Variable to store result of operation
                int res = 0;
                
                // Apply the correct operation
                switch (token) {
                    case "+": res = a + b; break; // addition
                    case "-": res = a - b; break; // subtraction
                    case "*": res = a * b; break; // multiplication
                    case "/": res = a / b; break; // division (truncates toward zero in Java)
                }
                // Push the result back onto the stack
                stack.push(res);
            } else {
                // If token is a number, convert string to integer and push onto stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        // At the end, stack has one element: the final result
        return stack.pop();
    }
}
