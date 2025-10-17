import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // stack to store indices of bars
        int maxArea = 0; // variable to store maximum area
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // use 0 height for a virtual bar at the end
            int h = (i == n) ? 0 : heights[i];

            // if current bar is smaller than stack top, calculate area
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // height of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // width of rectangle
                maxArea = Math.max(maxArea, height * width); // update max area
            }

            stack.push(i); // push current index to stack
        }

        return maxArea; // return maximum area found
    }
}
