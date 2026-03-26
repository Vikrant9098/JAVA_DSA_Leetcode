import java.util.HashMap;

class Solution {

    public boolean canPartitionGrid(int[][] grid) {

        int m = grid.length, n = grid[0].length; // get number of rows and columns

        long total = 0; // store total sum of all elements

        // maps to store frequency of elements in different partitions
        HashMap<Long, Integer> bottom = new HashMap<>(); // elements below horizontal cut
        HashMap<Long, Integer> top = new HashMap<>();    // elements above horizontal cut
        HashMap<Long, Integer> left = new HashMap<>();   // elements left of vertical cut
        HashMap<Long, Integer> right = new HashMap<>();  // elements right of vertical cut

        // initialize total sum and bottom/right maps with all elements
        for (int[] row : grid) {              // iterate each row
            for (int x : row) {              // iterate each element
                total += x;                  // add to total sum

                // add element frequency in bottom map
                bottom.put((long)x, bottom.getOrDefault((long)x, 0) + 1);

                // add element frequency in right map
                right.put((long)x, right.getOrDefault((long)x, 0) + 1);
            }
        }

        long sumTop = 0; // stores sum of top partition

        // try all possible horizontal cuts
        for (int i = 0; i < m - 1; i++) { // cut after row i

            // move current row from bottom to top
            for (int j = 0; j < n; j++) {

                int val = grid[i][j]; // current element

                sumTop += val; // add value to top sum

                // increase frequency in top map
                top.put((long)val, top.getOrDefault((long)val, 0) + 1);

                // decrease frequency in bottom map
                bottom.put((long)val, bottom.get((long)val) - 1);
            }

            long sumBottom = total - sumTop; // remaining sum is bottom

            // if both partitions equal → valid split
            if (sumTop == sumBottom) return true;

            long diff = Math.abs(sumTop - sumBottom); // difference between partitions

            // if top is larger, try removing diff from top
            if (sumTop > sumBottom) {

                // check if we can remove one element = diff from top
                if (check(top, grid, 0, i, 0, n - 1, diff)) return true;

            } else {

                // otherwise try removing from bottom
                if (check(bottom, grid, i + 1, m - 1, 0, n - 1, diff)) return true;
            }
        }

        long sumLeft = 0; // stores sum of left partition

        // try all possible vertical cuts
        for (int j = 0; j < n - 1; j++) { // cut after column j

            // move current column from right to left
            for (int i = 0; i < m; i++) {

                int val = grid[i][j]; // current element

                sumLeft += val; // add to left sum

                // increase frequency in left map
                left.put((long)val, left.getOrDefault((long)val, 0) + 1);

                // decrease frequency in right map
                right.put((long)val, right.get((long)val) - 1);
            }

            long sumRight = total - sumLeft; // remaining sum is right

            // if equal → valid split
            if (sumLeft == sumRight) return true;

            long diff = Math.abs(sumLeft - sumRight); // difference

            // if left larger, try removing from left
            if (sumLeft > sumRight) {

                if (check(left, grid, 0, m - 1, 0, j, diff)) return true;

            } else {

                // otherwise try removing from right
                if (check(right, grid, 0, m - 1, j + 1, n - 1, diff)) return true;
            }
        }

        return false; // no valid partition found
    }

    private boolean check(HashMap<Long, Integer> mp, int[][] grid,
                          int r1, int r2, int c1, int c2, long diff) {

        int rows = r2 - r1 + 1; // number of rows in partition
        int cols = c2 - c1 + 1; // number of columns in partition

        // if only one cell → cannot remove anything
        if (rows * cols == 1) return false;

        // if partition is a single row
        if (rows == 1) {

            // only first or last element can be removed
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }

        // if partition is a single column
        if (cols == 1) {

            // only top or bottom element can be removed
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }

        // general case: check if diff exists in map
        return mp.getOrDefault(diff, 0) > 0;
    }
}