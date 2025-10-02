class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list for graph representation
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); 
            // pre[1] -> pre[0] means: to take pre[0], you must finish pre[1]
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];

        // Check every course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false; // cycle detected, cannot finish all courses
            }
        }
        return true;
    }

    // DFS helper to detect cycle
    private boolean dfs(int course, List<List<Integer>> graph, int[] visited) {
        if (visited[course] == 1) {
            return false; // cycle found
        }
        if (visited[course] == 2) {
            return true; // already processed, no cycle here
        }

        // Mark current node as "visiting"
        visited[course] = 1;

        // Visit all neighbors (courses that depend on current course)
        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited)) {
                return false; // cycle detected in neighbor
            }
        }

        // Mark current node as "visited" (finished exploring)
        visited[course] = 2;
        return true;
    }
}
