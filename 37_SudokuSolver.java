class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Traverse through the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If we find an empty cell
                if (board[row][col] == '.') {
                    // Try digits 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // Place the digit

                            // Recursively try to solve the rest
                            if (solve(board)) {
                                return true;
                            } else {
                                // Backtrack
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false; // No valid digit found, need to backtrack
                }
            }
        }
        return true; // Solved
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) return false;
            // Check column
            if (board[i][col] == c) return false;
            // Check 3x3 sub-box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
