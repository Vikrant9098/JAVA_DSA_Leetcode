import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // If there are no intervals, return an empty 2D array
        if (intervals.length == 0) return new int[0][0];

        // Sort intervals by their start times (ascending order)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store the merged intervals
        List<int[]> result = new ArrayList<>();

        // Take the first interval as the current interval
        int[] current = intervals[0];
        result.add(current);

        // Loop through all intervals
        for (int[] interval : intervals) {
            // If the current interval overlaps with the previous one
            if (interval[0] <= current[1]) {
                // Merge them by updating the end time with the max end
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap → move to next interval
                current = interval;
                result.add(current);
            }
        }

        // Convert the result list back to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
