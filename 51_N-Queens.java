import java.util.*; // import utilities for using List and ArrayList

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // List to store all possible valid board configurations
        List<List<String>> result = new ArrayList<>();

        // Create an n x n chessboard represented by a 2D char array
        char[][] board = new char[n][n];

        // Initialize every cell on the board with '.'
        // ('.' means an empty square, 'Q' means a queen)
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Start solving the problem by placing queens row by row, starting from row 0
        backtrack(0, board, result, n);

        // Return the list of all valid solutions
        return result;
    }

    // This function tries to place queens row by row using backtracking
    private void backtrack(int row, char[][] board, List<List<String>> result, int n) {
        // Base case: if we have placed queens in all rows, we found a valid board
        if (row == n) {
            // Convert current board into a list of strings and add to result
            result.add(construct(board));
            return; // Go back to explore other possibilities
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            // Check if placing a queen at (row, col) is safe
            if (isSafe(board, row, col, n)) {
                // Place the queen at (row, col)
                board[row][col] = 'Q';

                // Move to the next row to place the next queen
                backtrack(row + 1, board, result, n);

                // Backtrack: remove the queen and try the next column
                board[row][col] = '.';
            }
        }
    }

    // This function checks if a queen can be safely placed at (row, col)
    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check vertically upwards (same column)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false; // another queen found in the same column
        }

        // Check upper-left diagonal (↖ direction)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false; // another queen found in upper-left diagonal
        }

        // Check upper-right diagonal (↗ direction)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false; // another queen found in upper-right diagonal
        }

        // If no conflicts, it’s safe to place the queen
        return true;
    }

    // Converts the board configuration (char[][]) into a list of strings for output
    private List<String> construct(char[][] board) {
        // Create a list to hold the string representation of the board
        List<String> res = new ArrayList<>();

        // For each row in the board
        for (char[] row : board) {
            // Convert the character array (row) to a string and add it to the list
            res.add(new String(row));
        }

        // Return this single valid configuration
        return res;
    }
}
