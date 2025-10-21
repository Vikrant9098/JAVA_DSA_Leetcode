class Solution {
    public int maximalRectangle(char[][] matrix) {
        // If matrix is empty, return 0
        if (matrix.length == 0) return 0;
        
        int cols = matrix[0].length;  // Number of columns
        int[] heights = new int[cols]; // Array to store heights for histogram
        int maxArea = 0;  // To store maximum rectangle area
        
        // Loop through each row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Update histogram heights for current row
            for (int j = 0; j < cols; j++) {
                // If '1', increase height; if '0', reset height
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            
            // Find the largest rectangle area for current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        // Return the maximum area found
        return maxArea;
    }

    // Helper function to calculate largest rectangle area in histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Stack to store indices
        int maxArea = 0;  // To store maximum area
        int n = heights.length;
        
        // Loop through all bars
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // Handle last bar as 0 height
            // While current height is less than top of stack height
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Pop height
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate width
                maxArea = Math.max(maxArea, height * width); // Update max area
            }
            // Push current index to stack
            stack.push(i);
        }
        
        // Return maximum area found
        return maxArea;
    }
}
