class Solution 
{
    public void setZeroes(int[][] matrix) 
    {
        int m = matrix.length, n = matrix[0].length; // Get matrix dimensions

        boolean firstRowZero = false, firstColZero = false; // Flags for first row & column

        // Step 1: Check if the first column needs to be zero
        for (int i = 0; i < m; i++) 
        {
            if (matrix[i][0] == 0) firstColZero = true; // If any element in first column is 0, mark firstColZero
        }

        // Step 2: Check if the first row needs to be zero
        for (int j = 0; j < n; j++) 
        {
            if (matrix[0][j] == 0) firstRowZero = true; // If any element in first row is 0, mark firstRowZero
        }

        // Step 3: Use the first row & column as markers for zeroes
        for (int i = 1; i < m; i++) 
        { // Start from row 1 (skip first row)
           
            for (int j = 1; j < n; j++) 
            { // Start from column 1 (skip first column)
                
                if (matrix[i][j] == 0) 
                { 
                    matrix[i][0] = 0; // Mark row in first column
                    matrix[0][j] = 0; // Mark column in first row
                }
            }
        }

        // Step 4: Set matrix elements to zero using the markers
        for (int i = 1; i < m; i++) 
        {
            for (int j = 1; j < n; j++) 
            {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) 
                {
                     // If row or column is marked, set cell to 0
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Handle first column separately if it needs to be zero
        if (firstColZero) 
        {
            for (int i = 0; i < m; i++) 
            {
                matrix[i][0] = 0; // Set entire first column to 0
            }
        }

        // Step 6: Handle first row separately if it needs to be zero
        if (firstRowZero) 
        {
            for (int j = 0; j < n; j++) 
            {
                matrix[0][j] = 0; // Set entire first row to 0
            }
        }
    }
}
