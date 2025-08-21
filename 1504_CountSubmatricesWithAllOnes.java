class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];

        // Step 1: Build heights (like histogram)
        for (int j = 0; j < n; j++) {
            heights[0][j] = mat[0][j];
            for (int i = 1; i < m; i++) {
                heights[i][j] = mat[i][j] == 0 ? 0 : heights[i - 1][j] + 1;
            }
        }

        int ans = 0;

        // Step 2: For each row, count submatrices using monotonic stack
        for (int i = 0; i < m; i++) {
            ans += countSubmatRow(heights[i]);
        }

        return ans;
    }

    // Helper: count submatrices ending at each row
    private int countSubmatRow(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n]; // number of submatrices ending at column j
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int res = 0;

        for (int j = 0; j < n; j++) {
            // maintain increasing stack
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            } else {
                sum[j] = heights[j] * (j + 1);
            }

            res += sum[j];
            stack.push(j);
        }

        return res;
    }
}
