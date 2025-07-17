import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        // Stack to keep track of characters and numbers
        Stack<String> stack = new Stack<>();
        int num = 0;  // Variable to store the current number for repetition
        StringBuilder currentString = new StringBuilder();  // To store current string without decoding

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // If character is a digit, update the number
                num = num * 10 + (c - '0');  // Handle multi-digit numbers
            } else if (c == '[') {
                // If we encounter '[', push the current string and number to stack
                stack.push(currentString.toString());
                stack.push(String.valueOf(num));
                currentString = new StringBuilder();  // Reset the current string
                num = 0;  // Reset the number to 0
            } else if (c == ']') {
                // If we encounter ']', pop the number and previous string from the stack
                int repeatTimes = Integer.parseInt(stack.pop());  // Get the repeat count
                String prevString = stack.pop();  // Get the previous string
                // Build the decoded string by repeating the current string
                StringBuilder decodedString = new StringBuilder(prevString);
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;  // Set the current string to the decoded string
            } else {
                // If it's a letter, simply append it to the current string
                currentString.append(c);
            }
        }

        return currentString.toString();  // Return the final decoded string
    }
}
