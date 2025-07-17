class Solution {
    public String removeStars(String s) {
        // Use StringBuilder as a stack to build the final string
        StringBuilder stack = new StringBuilder();

        // Loop through each character in the input string
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // If the character is '*', remove the last character from the stack
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                // If it's a letter, add it to the stack
                stack.append(ch);
            }
        }

        // Convert the StringBuilder stack to a string and return
        return stack.toString();
    }
}
