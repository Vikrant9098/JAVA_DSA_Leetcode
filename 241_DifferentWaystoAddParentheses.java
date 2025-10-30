import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();  // List to store all possible results

        // Loop through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);  // Get current character

            // Check if the character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Divide expression into left and right parts around the operator
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));   // Compute all results for left part
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1)); // Compute all results for right part

                // Combine each result from left and right based on the current operator
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') result.add(a + b);   // Add results for '+'
                        else if (c == '-') result.add(a - b); // Add results for '-'
                        else if (c == '*') result.add(a * b); // Add results for '*'
                    }
                }
            }
        }

        // If there were no operators (only a number), just add it to the result list
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));  // Convert string number to integer
        }

        return result;  // Return all computed results
    }
}
