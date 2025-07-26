import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // If there's 0 or 1 interval, nothing to remove
        if (intervals.length <= 1) return 0;

        // Sort intervals by their end time (greedy strategy)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;                 // Count of intervals to remove
        int prevEnd = intervals[0][1]; // End time of the first interval

        // Start from the second interval
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart < prevEnd) {
                // Overlapping interval, need to remove it
                count++;
            } else {
                // Non-overlapping, update the previous end
                prevEnd = currEnd;
            }
        }

        return count;
    }
}
