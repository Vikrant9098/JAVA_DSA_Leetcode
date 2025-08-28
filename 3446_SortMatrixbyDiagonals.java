import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        // Traverse diagonals starting from first column (bottom-left part including main diagonal)
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false); // sort in non-increasing order
        }
        
        // Traverse diagonals starting from first row (excluding main diagonal)
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true); // sort in non-decreasing order
        }
        
        return grid;
    }
    
    private void sortDiagonal(int[][] grid, int row, int col, boolean increasing) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();
        
        int r = row, c = col;
        while (r < n && c < n) {
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }
        
        if (increasing) {
            Collections.sort(diagonal); // non-decreasing
        } else {
            Collections.sort(diagonal, Collections.reverseOrder()); // non-increasing
        }
        
        // Put sorted values back
        r = row; 
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}
