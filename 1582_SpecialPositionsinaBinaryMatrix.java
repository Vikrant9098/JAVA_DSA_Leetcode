class Solution {

    public int numSpecial(int[][] mat) {
        
        int specials = 0;  // This will count the number of special positions
        
        // Traverse each row of the matrix
        for (int i = 0; i < mat.length; i++) {
            
            // Check if the current row contains exactly one '1'
            // If yes, return its column index, otherwise return -1
            int index = checkRow(mat, i);
            
            // If a valid column index is found AND
            // the corresponding column also contains only one '1'
            if (index >= 0 && checkColumn(mat, i, index))
                specials++;  // Increase count of special positions
        }

        return specials;  // Return total special positions
    }

    // This method checks whether a row contains exactly one '1'
    // If yes, it returns the column index of that '1'
    // If more than one '1' exists, it returns -1
    private int checkRow(int[][] mat, int i) {
        
        int index = -1;  // Stores column index of '1', initialized to -1 (means none found yet)
        
        // Traverse all columns of row 'i'
        for (int j = 0; j < mat[0].length; j++) {
            
            if (mat[i][j] == 1) {  // If a '1' is found
                
                // If already found a '1' before,
                // this means more than one '1' exists in this row
                if (index >= 0)
                    return -1;  // Not a valid special row
                
                else
                    index = j;  // Store column index of this '1'
            }
        }
        
        // Return the column index if exactly one '1' found
        // If no '1' found, index remains -1
        return index;
    }

    // This method checks whether the given column contains only one '1'
    // (i.e., the '1' at row i)
    private boolean checkColumn(int[][] mat, int i, int index) {
        
        // Traverse all rows for the given column index
        for (int j = 0; j < mat.length; j++) {
            
            // If another '1' is found in same column (excluding current row)
            if (mat[j][index] == 1 && j != i)
                return false;  // Column is not valid
        }
        
        return true;  // Column contains only one '1'
    }
}