import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // List to store the resulting merged intervals
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]); // No overlap, add interval as it is
            i++;
        }

        // Merge all intervals that overlap with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Update the start of newInterval to the minimum start
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            // Update the end of newInterval to the maximum end
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged new interval to the result
        result.add(newInterval);

        // Add all remaining intervals after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the list of intervals back to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
