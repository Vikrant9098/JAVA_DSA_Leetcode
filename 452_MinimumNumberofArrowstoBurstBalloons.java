import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Edge case: if there are no balloons, no arrows needed
        if (points.length == 0) return 0;

        // Sort the balloons based on their end coordinates (greedy strategy)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow is needed
        int lastArrowPos = points[0][1]; // Position of the first arrow at the end of first balloon

        // Iterate through the rest of the balloons
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position, we need a new arrow
            if (points[i][0] > lastArrowPos) {
                arrows++; // Increase arrow count
                lastArrowPos = points[i][1]; // Update arrow position
            }
            // Else, the current balloon overlaps with the previous, and is burst by the same arrow
        }

        return arrows;
    }
}
