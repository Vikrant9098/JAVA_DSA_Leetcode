class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;            // size of board (n x n)
        int target = n * n;              // last square number

        // BFS queue: {current cell, moves so far}
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1]; // track visited squares

        queue.offer(new int[]{1, 0});    // start from square 1 with 0 moves
        visited[1] = true;               // mark starting square as visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();   // take current cell from queue
            int cell = curr[0], moves = curr[1]; // current square and moves count

            if (cell == target) return moves;   // reached last square → done

            // try dice rolls from 1 to 6
            for (int dice = 1; dice <= 6 && cell + dice <= target; dice++) {
                int next = cell + dice;          // next square
                int[] pos = getCoordinates(next, n); // convert square number to (row, col)

                // if ladder or snake exists, move to its destination
                if (board[pos[0]][pos[1]] != -1) {
                    next = board[pos[0]][pos[1]];
                }

                // if this square not visited yet, add to queue
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1}); // increment moves
                }
            }
        }

        return -1; // cannot reach last square
    }

    // Convert square number to (row, col) on board
    private int[] getCoordinates(int cell, int n) {
        int row = n - 1 - (cell - 1) / n; // calculate row from bottom
        int col = (cell - 1) % n;         // calculate column from left

        // reverse column if row is odd (zigzag pattern)
        if (((n - 1 - row) % 2) == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col}; // return (row, col)
    }
}
