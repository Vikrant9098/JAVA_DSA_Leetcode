class Solution {
    public int totalNQueens(int n) {
        // Counter to store number of valid solutions
        int[] count = new int[1];
        // Start backtracking with empty board
        solve(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n], count);
        return count[0]; // Return total number of valid ways
    }

    // Backtracking helper method
    private void solve(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2, int[] count) {
        // If all queens are placed successfully, increase the count
        if (row == n) {
            count[0]++;
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n; // Diagonal 1 (top-left to bottom-right)
            int id2 = col + row;     // Diagonal 2 (top-right to bottom-left)

            // Check if the position is under attack
            if (cols[col] || d1[id1] || d2[id2]) continue;

            // Place the queen (mark columns and diagonals as occupied)
            cols[col] = d1[id1] = d2[id2] = true;

            // Move to the next row
            solve(row + 1, n, cols, d1, d2, count);

            // Backtrack (remove the queen and unmark)
            cols[col] = d1[id1] = d2[id2] = false;
        }
    }
}
