class Solution {
    public int calculate(String s) {
        int num = 0; // to build current number
        char op = '+'; // previous operator, default '+'
        Stack<Integer> stack = new Stack<>(); // to store numbers

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // if it's a digit, build the number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // if it's an operator or last character, process previous operator
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(num); // add number
                } else if (op == '-') {
                    stack.push(-num); // subtract number
                } else if (op == '*') {
                    stack.push(stack.pop() * num); // multiply with top
                } else if (op == '/') {
                    stack.push(stack.pop() / num); // divide top by num
                }
                op = c;  // update operator
                num = 0; // reset number
            }
        }

        int result = 0;
        for (int val : stack) result += val; // sum all numbers in stack
        return result;
    }
}
