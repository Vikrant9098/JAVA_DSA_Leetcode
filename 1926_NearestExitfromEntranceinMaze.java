class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // Get the dimensions of the maze
        int m = maze.length;
        int n = maze[0].length;

        // Queue to perform BFS. Each element is an int[]: [row, col, steps from entrance]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        // Mark the entrance as visited so we don't revisit it
        maze[entrance[0]][entrance[1]] = '+';

        // Directions array for movement: up, down, left, right
        int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        // Start BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // Get the current cell from queue
            int row = current[0], col = current[1], steps = current[2];

            // Explore all 4 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new cell is inside the maze and is an empty cell
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                    
                    // Check if it's an exit (i.e., on the border of the maze and not the entrance)
                    if (newRow == 0 || newRow == m-1 || newCol == 0 || newCol == n-1) {
                        return steps + 1; // Found the nearest exit, return the number of steps
                    }

                    // Mark the cell as visited
                    maze[newRow][newCol] = '+';

                    // Add the new cell to the queue with incremented step count
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        // If we exit the loop, it means there is no exit reachable
        return -1;
    }
}
