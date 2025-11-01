import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        // Create a list to store all valid expressions
        List<String> result = new ArrayList<>();
        
        // If input string is empty, return empty list
        if (num == null || num.length() == 0) return result;
        
        // Start backtracking from index 0
        backtrack(result, "", num, target, 0, 0, 0);
        
        // Return the final list of expressions
        return result;
    }

    private void backtrack(List<String> result, String path, String num, int target, int index, long eval, long prevNum) {
        // If we reached the end of the string
        if (index == num.length()) {
            // If the evaluated value equals the target, add expression to result
            if (eval == target) {
                result.add(path);
            }
            return; // Stop recursion
        }

        // Try all possible splits of the string
        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zeros
            if (i != index && num.charAt(index) == '0') break;

            // Convert substring to a number
            long currNum = Long.parseLong(num.substring(index, i + 1));

            // If it's the first number, start without an operator
            if (index == 0) {
                backtrack(result, path + currNum, num, target, i + 1, currNum, currNum);
            } else {
                // Try adding '+'
                backtrack(result, path + "+" + currNum, num, target, i + 1, eval + currNum, currNum);

                // Try adding '-'
                backtrack(result, path + "-" + currNum, num, target, i + 1, eval - currNum, -currNum);

                // Try adding '*' and handle precedence by adjusting eval
                backtrack(result, path + "*" + currNum, num, target, i + 1, eval - prevNum + prevNum * currNum, prevNum * currNum);
            }
        }
    }
}
