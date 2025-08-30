class Solution {
    public boolean isValidSudoku(char[][] board) {
        // We will use 3 hash sets for each row, column, and 3x3 sub-box
        // rows[i][num] = true means number num is already used in row i
        // cols[j][num] = true means number num is already used in column j
        // boxes[k][num] = true means number num is already used in 3x3 box k
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Traverse each cell in the 9x9 Sudoku board
        for (int i = 0; i < 9; i++) {           // loop through each row
            for (int j = 0; j < 9; j++) {       // loop through each column
                char c = board[i][j];           // get the current cell

                if (c == '.') continue;         // skip empty cells ('.')

                int num = c - '1';              // convert char '1'..'9' to index 0..8

                // Calculate which 3x3 box this cell belongs to
                // Formula: (row/3) * 3 + (col/3)
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check if the number already exists in the current row
                if (rows[i][num]) return false;

                // Check if the number already exists in the current column
                if (cols[j][num]) return false;

                // Check if the number already exists in the current 3x3 box
                if (boxes[boxIndex][num]) return false;

                // Otherwise, mark the number as seen in row, column, and box
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        // If no conflicts found, the Sudoku board is valid
        return true;
    }
}
