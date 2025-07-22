import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        // Get the dimensions of the grid
        int rows = grid.length;
        int cols = grid[0].length;

        // Queue to perform BFS - stores rotten oranges with their position and time
        Queue<int[]> queue = new LinkedList<>();

        // Count of fresh oranges
        int fresh = 0;

        // Loop through the grid to find initial rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If the orange is rotten, add it to the queue with time 0
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c, 0});
                }
                // If it's a fresh orange, increment the fresh count
                else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // Directions array for 4-directional movement (up, down, left, right)
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Track the time taken to rot all reachable fresh oranges
        int time = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int t = current[2];

            // Update time with the current time
            time = Math.max(time, t);

            // Explore all 4 directions
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // Check if new position is within bounds and has a fresh orange
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    grid[newRow][newCol] == 1) {
                    
                    // Rot the fresh orange
                    grid[newRow][newCol] = 2;

                    // Decrease the count of fresh oranges
                    fresh--;

                    // Add the newly rotten orange to the queue with incremented time
                    queue.offer(new int[]{newRow, newCol, t + 1});
                }
            }
        }

        // If there are still fresh oranges left, return -1
        if (fresh > 0) {
            return -1;
        }

        // Return total time taken
        return time;
    }
}
