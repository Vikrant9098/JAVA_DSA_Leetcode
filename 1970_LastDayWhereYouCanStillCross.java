import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // Checks if crossing is possible on day t
    public boolean isPossible(int m, int n, int t, int[][] cells) {

        int[][] grid = new int[m + 1][n + 1]; 
        // Grid to mark water(1) and land(0), 1-based indexing

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        // Down, Up, Right, Left moves

        for (int i = 0; i < t; i++) {
            grid[cells[i][0]][cells[i][1]] = 1; 
            // Mark first t cells as water
        }

        Queue<int[]> queue = new LinkedList<>();
        // Queue for BFS traversal

        for (int i = 1; i <= n; i++) {
            if (grid[1][i] == 0) {
                queue.offer(new int[]{1, i}); 
                // Start BFS from top row land cells

                grid[1][i] = 1; 
                // Mark cell as visited
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); 
            // Take current cell from queue

            int r = cell[0], c = cell[1]; 
            // Current row and column

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1]; 
                // New row and column

                if (nr > 0 && nc > 0 && nr <= m && nc <= n && grid[nr][nc] == 0) {
                    // Check bounds and if cell is land

                    grid[nr][nc] = 1; 
                    // Mark cell as visited

                    if (nr == m) {
                        return true; 
                        // Reached bottom row → crossing possible
                    }

                    queue.offer(new int[]{nr, nc}); 
                    // Add next cell to BFS
                }
            }
        }

        return false; 
        // No path found to bottom row
    }

    // Finds the latest day crossing is possible
    public int latestDayToCross(int row, int col, int[][] cells) {

        int left = 0, right = row * col, latestPossibleDay = 0;
        // Binary search range on days

        while (left < right - 1) {

            int mid = left + (right - left) / 2; 
            // Middle day

            if (isPossible(row, col, mid, cells)) {
                left = mid; 
                // Crossing possible → move right

                latestPossibleDay = mid; 
                // Store valid day
            } else {
                right = mid; 
                // Crossing not possible → move left
            }
        }

        return latestPossibleDay; 
        // Return last valid day
    }
}
