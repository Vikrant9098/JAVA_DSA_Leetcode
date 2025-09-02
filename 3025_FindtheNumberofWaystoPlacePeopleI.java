class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;              // To count valid pairs
        int n = points.length;      // Total number of points

        // Loop over all points as A
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];  // Coordinates of point A

            // Loop over all points as B
            for (int j = 0; j < n; j++) {
                if (i == j) continue;   // Skip if same point
                int x2 = points[j][0], y2 = points[j][1];  // Coordinates of point B

                // Check if A is NOT upper-left of B
                if (x1 > x2 || y1 < y2) continue;

                boolean flag = true;  // Assume rectangle is empty

                // Check every other point
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;   // Skip A and B
                    int x = points[k][0], y = points[k][1];  // Coordinates of point P

                    // If P lies inside or on the rectangle made by A and B
                    if (x >= x1 && x <= x2 && y <= y1 && y >= y2) {
                        flag = false;  // Rectangle is not empty
                        break;         // No need to check further
                    }                        
                }

                // If rectangle is empty, count the pair
                if (flag == true) count++;
            }
        }

        return count;   // Return total valid pairs
    }
}
