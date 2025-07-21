class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;          // Number of cities (rows or columns of the matrix)
        boolean[] visited = new boolean[n];  // Array to track which cities have been visited
        int count = 0;                       // Counter for the number of provinces

        // Loop through each city
        for (int i = 0; i < n; i++) {
            // If the city has not been visited, it's a new province
            if (!visited[i]) {
                dfs(isConnected, visited, i);  // Start DFS from this city
                count++;                       // One province completed
            }
        }

        return count;  // Return total number of provinces
    }

    // Depth-First Search function to visit all cities in the same province
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;  // Mark the current city as visited

        for (int j = 0; j < isConnected.length; j++) {
            // If city i is connected to city j and j has not been visited
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);  // Recursively visit city j
            }
        }
    }
}
