class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        
        // Compare each row with each column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Get row i
                int[] row = grid[i];
                
                // Get column j
                int[] col = new int[n];
                for (int k = 0; k < n; k++) {
                    col[k] = grid[k][j];
                }
                
                // Check if row and column are equal
                if (Arrays.equals(row, col)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}