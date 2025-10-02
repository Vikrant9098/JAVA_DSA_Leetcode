class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list to represent graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // initialize empty list for each course
        }

        // Step 2: Create indegree array to count prerequisites for each course
        int[] indegree = new int[numCourses];

        // Step 3: Build the graph and fill indegree array
        for (int[] pre : prerequisites) {
            int course = pre[0];   // course that depends on a prerequisite
            int prereq = pre[1];   // prerequisite course
            graph.get(prereq).add(course); // add edge prereq -> course
            indegree[course]++;    // increase indegree of "course"
        }

        // Step 4: Queue to store courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) { // if course has no prerequisites
                queue.add(i);       // we can take it right away
            }
        }

        // Step 5: Array to store the order of courses
        int[] order = new int[numCourses];
        int index = 0; // position in order array

        // Step 6: Process courses in the queue
        while (!queue.isEmpty()) {
            int current = queue.poll(); // take one course
            order[index++] = current;   // add it to the order

            // Step 7: Go through all courses that depend on "current"
            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--; // reduce prerequisite count
                if (indegree[neighbor] == 0) { // if no prerequisites left
                    queue.add(neighbor);       // add to queue
                }
            }
        }

        // Step 8: Check if we were able to take all courses
        if (index == numCourses) {
            return order; // valid order found
        } else {
            return new int[0]; // cycle detected, return empty array
        }
    }
}
