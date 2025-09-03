import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort points by x ascending, and if x is same then y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int n = points.length; // number of points
        int result = 0;        // answer count

        // Fix Alice's position at i
        for (int i = 0; i < n; i++) {
            int top = points[i][1];       // Alice's y (top boundary of fence)
            int bot = Integer.MIN_VALUE;  // current bottom boundary (start very low)

            // Move Bob's position to the right (larger x)
            for (int j = i + 1; j < n; j++) {
                int y = points[j][1]; // Bob's y

                // Bob's y must be inside (bot, top]
                if (bot < y && y <= top) {
                    result++;   // valid Alice-Bob pair
                    bot = y;    // update bottom boundary (tighten fence)
                    
                    // If bottom reached top, no more valid pairs possible
                    if (bot == top) break;
                }
            }
        }

        return result; // return total valid pairs
    }
}
