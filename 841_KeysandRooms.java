class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Create a boolean array to keep track of visited rooms.
        // visited[i] is true if room i has been visited.
        boolean[] visited = new boolean[rooms.size()];

        // Start DFS from room 0 (since it is initially unlocked)
        dfs(0, rooms, visited);

        // After DFS traversal, check if all rooms have been visited
        for (boolean v : visited) {
            // If any room is not visited, return false
            if (!v) return false;
        }

        // All rooms have been visited, return true
        return true;
    }

    // Helper function to perform Depth-First Search
    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        // If the current room is already visited, skip it
        if (visited[room]) return;

        // Mark the current room as visited
        visited[room] = true;

        // Loop through all keys found in the current room
        for (int key : rooms.get(room)) {
            // Use the key to enter the next room via DFS
            dfs(key, rooms, visited);
        }
    }
}
