import java.util.*;
// Import utility classes

class Solution {
    // Solution class

    public int maxTwoEvents(int[][] events) {
        // Function to find maximum value from at most two non-overlapping events

        int n = events.length;
        // Number of events
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // Sort events by start time
        
        int[] suffixMax = new int[n];
        // suffixMax[i] stores max event value from index i to end

        suffixMax[n - 1] = events[n - 1][2];
        // Initialize with last event's value
        
        for (int i = n - 2; i >= 0; --i) {
            // Traverse events from right to left
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
            // Store maximum value so far
        }
        
        int maxSum = 0;
        // Stores maximum value of selected events
        
        for (int i = 0; i < n; ++i) {
            // Iterate through each event

            int left = i + 1, right = n - 1;
            // Binary search boundaries
            
            int nextEventIndex = -1;
            // Stores index of next non-overlapping event
            
            while (left <= right) {
                // Binary search loop
                int mid = left + (right - left) / 2;
                // Find middle index

                if (events[mid][0] > events[i][1]) {
                    // If next event starts after current ends
                    nextEventIndex = mid;
                    // Possible valid event
                    right = mid - 1;
                    // Try to find earlier valid event
                } else {
                    left = mid + 1;
                    // Move search to right side
                }
            }
            
            if (nextEventIndex != -1) {
                // If a valid next event is found
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
                // Update max sum using two events
            }
            
            maxSum = Math.max(maxSum, events[i][2]);
            // Update max sum using only current event
        }
        
        return maxSum;
        // Return maximum value obtained
    }
}
