import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];         // Result array to store number of days to wait
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of temperatures

        // Traverse the temperature array from end to start
        for (int i = n - 1; i >= 0; i--) {
            // Pop all indices with temperature less than or equal to current day's temperature
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // If stack is not empty, calculate the days to wait
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }

            // Push current index onto the stack
            stack.push(i);
        }

        return answer;
    }
}
