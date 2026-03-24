// This solution computes product of all elements except current cell (mod 12345)
class Solution {

    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345; // given modulo
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m]; // result matrix

        long suffix = 1; // stores product of elements after current cell

        // Traverse from bottom-right, top-left to compute suffix products
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suffix; // store product of all elements after (i,j)
                suffix = (suffix * grid[i][j]) % MOD; // update suffix including current
            }
        }

        long prefix = 1; // stores product of elements before current cell

        // Traverse from top-left, bottom-right to combine prefix and suffix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // multiply prefix (before) and suffix (after)
                p[i][j] = (int) (((long) p[i][j] * prefix) % MOD);

                prefix = (prefix * grid[i][j]) % MOD; // update prefix including current
            }
        }

        return p; // final matrix where each cell = product of all other elements
    }
}