class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;    // Number of rows
        int n = board[0].length; // Number of columns

        // Try to start DFS from every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true; // Found the word
                }
            }
        }
        return false; // Word not found
    }

    // DFS helper function
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // If index reached word length, all characters matched
        if (index == word.length()) return true;

        // Check boundaries and if current cell matches current character
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];  // Store the original character
        board[row][col] = '#';        // Mark the cell as visited

        // Explore 4 directions: up, down, left, right
        boolean found = dfs(board, word, index + 1, row + 1, col) ||
                        dfs(board, word, index + 1, row - 1, col) ||
                        dfs(board, word, index + 1, row, col + 1) ||
                        dfs(board, word, index + 1, row, col - 1);

        board[row][col] = temp; // Restore the original character (backtrack)

        return found; // Return true if word found in any direction
    }
}
