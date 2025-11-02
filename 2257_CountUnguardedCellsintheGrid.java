class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // create grid of m x n
        int[][] grid = new int[m][n];
        
        // mark guards as 1
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        
        // mark walls as 2
        for (int[] w : walls) grid[w[0]][w[1]] = 2;
        
        // directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        // for each guard
        for (int[] g : guards) {
            // move in all 4 directions
            for (int[] d : dirs) {
                int r = g[0] + d[0], c = g[1] + d[1];
                
                // keep moving until wall or guard found
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    // mark as guarded if empty
                    if (grid[r][c] == 0) grid[r][c] = 3;
                    // move further in same direction
                    r += d[0];
                    c += d[1];
                }
            }
        }
        
        // count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if cell is empty (0), increase count
                if (grid[i][j] == 0) count++;
            }
        }
        
        // return total unguarded cells
        return count;
    }
}
