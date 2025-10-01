class Solution {
    public int numIslands(char[][] grid) {
        // number of rows
        int rows = grid.length;
        // number of columns
        int cols = grid[0].length;
        // count of islands
        int count = 0;
        
        // iterate through each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if cell is land ('1'), start DFS
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    count++; // after DFS, increment island count
                }
            }
        }
        return count;
    }
    
    // DFS to mark all connected lands
    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // base case: out of bounds or water
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }
        
        // mark current cell as visited by setting to '0'
        grid[i][j] = '0';
        
        // explore all 4 directions
        dfs(grid, i + 1, j, rows, cols); // down
        dfs(grid, i - 1, j, rows, cols); // up
        dfs(grid, i, j + 1, rows, cols); // right
        dfs(grid, i, j - 1, rows, cols); // left
    }
}
