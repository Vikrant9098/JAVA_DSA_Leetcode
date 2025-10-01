class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // mark all 'O's on the border and connected to border as safe
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0, rows, cols);         // left border
            dfs(board, i, cols - 1, rows, cols);  // right border
        }
        
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j, rows, cols);         // top border
            dfs(board, rows - 1, j, rows, cols);  // bottom border
        }
        
        // convert all 'O' to 'X', and 'S' (safe) back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // captured
                if (board[i][j] == 'S') board[i][j] = 'O'; // safe
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j, int rows, int cols) {
        // base case: out of bounds or not 'O'
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') return;
        
        // mark current 'O' as safe
        board[i][j] = 'S';
        
        // explore all 4 directions
        dfs(board, i + 1, j, rows, cols); // down
        dfs(board, i - 1, j, rows, cols); // up
        dfs(board, i, j + 1, rows, cols); // right
        dfs(board, i, j - 1, rows, cols); // left
    }
}
