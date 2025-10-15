class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0; // store the maximum valid length
        Stack<Integer> stack = new Stack<>(); // stack to store indices
        stack.push(-1); // base index to handle edge cases

        for (int i = 0; i < s.length(); i++) { // loop through the string
            if (s.charAt(i) == '(') {
                stack.push(i); // push index of '(' onto the stack
            } else {
                stack.pop(); // pop one element for matching ')'
                if (stack.isEmpty()) {
                    stack.push(i); // push current index as base for next valid substring
                } else {
                    // calculate length of current valid substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen; // return the maximum valid length found
    }
}
