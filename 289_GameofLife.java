class Solution {  // Define Solution class
    public void gameOfLife(int[][] board) {  // Main method that updates board in-place
        int rows = board.length;         // Get number of rows
        int cols = board[0].length;      // Get number of columns

        // Define 8 possible directions (neighbors: vertical, horizontal, diagonal)
        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        // Step 1: Traverse each cell in the board
        for (int r = 0; r < rows; r++) {       // Loop over rows
            for (int c = 0; c < cols; c++) {   // Loop over columns
                int liveNeighbors = 0;         // Counter for live neighbors

                // Step 2: Count live neighbors for this cell
                for (int[] d : directions) {   // Loop over all 8 directions
                    int nr = r + d[0];         // Neighbor row index
                    int nc = c + d[1];         // Neighbor column index

                    // Check if neighbor is inside the board
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        // Use abs() so we count both live (1) and temp dead (-1) as live
                        if (Math.abs(board[nr][nc]) == 1) {
                            liveNeighbors++;   // Increase live neighbor count
                        }
                    }
                }

                // Step 3: Apply Game of Life rules with temporary markers
                // Rule 1 & 3: Any live cell with <2 or >3 neighbors dies → mark as -1
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[r][c] = -1;  // Mark live → dead
                }
                // Rule 4: Any dead cell with exactly 3 neighbors becomes live → mark as 2
                if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = 2;   // Mark dead → live
                }
            }
        }

        // Step 4: Final pass to update board with 0s and 1s
        for (int r = 0; r < rows; r++) {       // Loop rows again
            for (int c = 0; c < cols; c++) {   // Loop cols again
                if (board[r][c] > 0) {         // If value is 1 or 2 → live
                    board[r][c] = 1;           // Set as alive
                } else {                       // If value is 0 or -1 → dead
                    board[r][c] = 0;           // Set as dead
                }
            }
        }
    }
}
