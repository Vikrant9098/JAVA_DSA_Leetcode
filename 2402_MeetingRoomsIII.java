class Solution {

    public int mostBooked(int n, int[][] meetings) {

        int[] ans = new int[n];          // ans[i] = number of meetings booked in room i
        long[] times = new long[n];      // times[i] = when room i becomes free

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Go through each meeting
        for (int i = 0; i < meetings.length; i++) {

            int start = meetings[i][0]; // meeting start time
            int end = meetings[i][1];   // meeting end time

            boolean flag = false;       // true if we find a free room
            int minind = -1;            // index of earliest free room
            long val = Long.MAX_VALUE;  // earliest free time

            // Check all rooms
            for (int j = 0; j < n; j++) {

                // Track room that gets free the earliest
                if (times[j] < val) {
                    val = times[j];
                    minind = j;
                }

                // If room is free before meeting starts
                if (times[j] <= start) {
                    flag = true;        // free room found
                    ans[j]++;           // increase meeting count
                    times[j] = end;     // update free time
                    break;              // stop checking other rooms
                }
            }

            // If no room was free
            if (!flag) {
                ans[minind]++;                          // use earliest free room
                times[minind] += (end - start);         // delay meeting
            }
        }

        int maxi = -1, id = -1;         // max meetings and room index

        // Find room with maximum meetings
        for (int i = 0; i < n; i++) {
            if (ans[i] > maxi) {
                maxi = ans[i];
                id = i;
            }
        }

        return id;                      // return most used room
    }
}
