class Solution {
  public int minimumSum(int[][] grid) {
    final int m = grid.length;            // number of rows
    final int n = grid[0].length;         // number of cols
    int ans = m * n;                      // start with max possible area

    // Case 1: top rectangle + bottom split into left & right
    for (int i = 0; i < m; ++i) {
      final int top = minimumArea(grid, 0, i, 0, n - 1);   // rectangle covering rows 0..i
      for (int j = 0; j < n; ++j)
        ans = Math.min(ans, top 
                          + minimumArea(grid, i + 1, m - 1, 0, j)   // left bottom
                          + minimumArea(grid, i + 1, m - 1, j + 1, n - 1)); // right bottom
    }

    // Case 2: bottom rectangle + top split into left & right
    for (int i = 0; i < m; ++i) {
      final int bottom = minimumArea(grid, i, m - 1, 0, n - 1);   // rectangle covering rows i..end
      for (int j = 0; j < n; ++j)
        ans = Math.min(ans, bottom 
                          + minimumArea(grid, 0, i - 1, 0, j)     // top left
                          + minimumArea(grid, 0, i - 1, j + 1, n - 1)); // top right
    }

    // Case 3: left rectangle + right split into top & bottom
    for (int j = 0; j < n; ++j) {
      final int left = minimumArea(grid, 0, m - 1, 0, j);   // rectangle covering cols 0..j
      for (int i = 0; i < m; ++i)
        ans = Math.min(ans, left
                          + minimumArea(grid, 0, i, j + 1, n - 1)   // top right
                          + minimumArea(grid, i + 1, m - 1, j + 1, n - 1)); // bottom right
    }

    // Case 4: right rectangle + left split into top & bottom
    for (int j = 0; j < n; ++j) {
      final int right = minimumArea(grid, 0, m - 1, j, n - 1);   // rectangle covering cols j..end
      for (int i = 0; i < m; ++i)
        ans = Math.min(ans, right
                          + minimumArea(grid, 0, i, 0, j - 1)    // top left
                          + minimumArea(grid, i + 1, m - 1, 0, j - 1)); // bottom left
    }

    // Case 5: split rows into 3 horizontal bands
    for (int i1 = 0; i1 < m; ++i1)
      for (int i2 = i1 + 1; i2 < m; ++i2)
        ans = Math.min(ans,
                       minimumArea(grid, 0, i1, 0, n - 1)      // top
                     + minimumArea(grid, i1 + 1, i2, 0, n - 1) // middle
                     + minimumArea(grid, i2 + 1, m - 1, 0, n - 1)); // bottom

    // Case 6: split cols into 3 vertical bands
    for (int j1 = 0; j1 < n; ++j1)
      for (int j2 = j1 + 1; j2 < n; ++j2)
        ans = Math.min(ans,
                       minimumArea(grid, 0, m - 1, 0, j1)      // left
                     + minimumArea(grid, 0, m - 1, j1 + 1, j2) // middle
                     + minimumArea(grid, 0, m - 1, j2 + 1, n - 1)); // right

    return ans;  // return the minimum sum of areas
  }

  // helper: find minimum rectangle area covering all 1s in given subgrid
  private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
    int x1 = Integer.MAX_VALUE;   // min row of 1
    int y1 = Integer.MAX_VALUE;   // min col of 1
    int x2 = 0;                   // max row of 1
    int y2 = 0;                   // max col of 1
    for (int i = si; i <= ei; ++i)
      for (int j = sj; j <= ej; ++j)
        if (grid[i][j] == 1) {    // found a 1
          x1 = Math.min(x1, i);   // update min row
          y1 = Math.min(y1, j);   // update min col
          x2 = Math.max(x2, i);   // update max row
          y2 = Math.max(y2, j);   // update max col
        }
    return x1 == Integer.MAX_VALUE ? 0   // if no 1’s → area = 0
           : (x2 - x1 + 1) * (y2 - y1 + 1); // else bounding rectangle area
  }
}
