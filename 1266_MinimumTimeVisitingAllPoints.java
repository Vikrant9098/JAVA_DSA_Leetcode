class Solution {                          // Define the Solution class

    public int minTimeToVisitAllPoints(int[][] points) { // Method to calculate minimum time
        int ans = 0;                      // Variable to store total time

        for (int i = 1; i < points.length; ++i) { // Loop through points starting from second point
            int[] cur = points[i],        // Current point
                  prev = points[i - 1];   // Previous point

            ans += Math.max(              // Add the maximum distance needed
                Math.abs(cur[0] - prev[0]), // Absolute x-distance
                Math.abs(cur[1] - prev[1])  // Absolute y-distance
            );
        }

        return ans;                       // Return total time
    }
}
