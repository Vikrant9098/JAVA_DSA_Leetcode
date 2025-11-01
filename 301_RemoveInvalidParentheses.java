import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>(); // to store final valid strings
        if (s == null) return result; // if input is null, return empty list

        Set<String> visited = new HashSet<>(); // to avoid checking same string again
        Queue<String> queue = new LinkedList<>(); // for BFS traversal
        queue.add(s); // start with the original string
        visited.add(s); // mark original string as visited
        boolean found = false; // to stop after finding first valid level

        while (!queue.isEmpty()) { // run while there are strings to process
            String str = queue.poll(); // take one string from queue

            if (isValid(str)) { // check if the string has valid parentheses
                result.add(str); // add it to result
                found = true; // mark as found valid level
            }

            if (found) continue; // skip next removals if already found valid ones

            // try removing one parenthesis at a time
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue; // skip letters

                // remove one parenthesis and create new string
                String next = str.substring(0, i) + str.substring(i + 1);

                // if not visited before, add to queue
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return result; // return all valid strings
    }

    // helper function to check if a string is valid parentheses
    private boolean isValid(String s) {
        int count = 0; // to track balance of parentheses
        for (char c : s.toCharArray()) { // check every character
            if (c == '(') count++; // count opening
            else if (c == ')') count--; // count closing
            if (count < 0) return false; // too many closing brackets
        }
        return count == 0; // valid only if all opens are closed
    }
}
