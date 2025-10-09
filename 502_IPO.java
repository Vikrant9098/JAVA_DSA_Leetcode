import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;  // number of projects

        // Create a list of pairs (capital, profit) for each project
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i]; // required capital
            projects[i][1] = profits[i]; // profit from project
        }

        // Sort projects based on required capital (ascending)
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        // Max-heap to store profits of affordable projects
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0; // pointer to iterate over sorted projects

        // Choose at most k projects
        for (int count = 0; count < k; count++) {
            // Add all projects that can be started with current capital
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]); // add profit to heap
                i++;
            }

            // If no project can be started, stop
            if (maxHeap.isEmpty()) break;

            // Pick the project with the maximum profit
            w += maxHeap.poll();
        }

        return w; // return final maximized capital
    }
}
