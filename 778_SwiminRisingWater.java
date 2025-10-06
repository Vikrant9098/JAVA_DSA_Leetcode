import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length; // Get the size of the grid (n x n)

        // Min-heap to always pick the cell with the smallest elevation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[][] visited = new boolean[n][n]; // To track visited cells

        // Start from the top-left cell (elevation, row, col)
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true; // Mark starting cell as visited

        // 4 possible movement directions (down, up, right, left)
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int time = 0; // Keeps track of the maximum elevation we have stepped on

        // Process cells until we reach the bottom-right corner
        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get the cell with the smallest elevation
            int height = current[0];   // Current cell elevation
            int r = current[1];        // Current row
            int c = current[2];        // Current column

            // Update time to the highest elevation we've encountered so far
            time = Math.max(time, height);

            // If we reached bottom-right cell, return the time
            if (r == n - 1 && c == n - 1) return time;

            // Explore all 4 directions
            for (int[] dir : directions) {
                int nr = r + dir[0]; // New row
                int nc = c + dir[1]; // New column

                // Check boundaries and whether the cell is already visited
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true; // Mark as visited
                    pq.offer(new int[]{grid[nr][nc], nr, nc}); // Add new cell to the heap
                }
            }
        }

        return -1; // Return -1 (should never happen as we’ll always reach the end)
    }
}
