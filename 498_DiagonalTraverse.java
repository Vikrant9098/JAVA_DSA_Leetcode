class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;          // number of rows
        int n = mat[0].length;       // number of columns
        int[] result = new int[m * n]; // output array to store diagonal order
        
        int row = 0, col = 0;        // starting position
        int dir = 1;                 // direction: 1 = up-right, -1 = down-left
        int idx = 0;                 // index for result array

        while (idx < m * n) {        // loop until we fill all elements
            result[idx++] = mat[row][col]; // store current element
            
            if (dir == 1) {          // moving up-right
                if (col == n - 1) {  // if at last column
                    row++;           // move down
                    dir = -1;        // change direction to down-left
                } else if (row == 0) { // if at top row
                    col++;           // move right
                    dir = -1;        // change direction to down-left
                } else {             // otherwise, keep moving up-right
                    row--; 
                    col++;
                }
            } else {                 // moving down-left
                if (row == m - 1) {  // if at last row
                    col++;           // move right
                    dir = 1;         // change direction to up-right
                } else if (col == 0) { // if at first column
                    row++;           // move down
                    dir = 1;         // change direction to up-right
                } else {             // otherwise, keep moving down-left
                    row++;
                    col--;
                }
            }
        }
        
        return result;               // return the final diagonal order
    }
}
