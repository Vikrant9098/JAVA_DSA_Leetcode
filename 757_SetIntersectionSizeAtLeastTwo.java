class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // Sort intervals by end value (small first)
        // If same end, sort by start value (large first)
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int ans = 0;   // total numbers added to the answer set
        int a = -1, b = -1; // two largest chosen numbers so far

        for (int[] it : intervals) {   // loop through each interval
            int l = it[0], r = it[1];  // interval start and end

            // Case 1: interval has 0 chosen numbers inside
            if (l > b) {
                a = r - 1;  // choose r-1 as the first new number
                b = r;      // choose r as the second new number
                ans += 2;   // we added 2 numbers
            } 
            // Case 2: interval has exactly 1 chosen number inside
            else if (l > a) {
                a = b;      // move b to a (it becomes the smaller one)
                b = r;      // choose r as the new number
                ans += 1;   // we added 1 number
            }
            // Case 3: interval already has 2 numbers -> do nothing
        }

        return ans; // return total numbers added
    }
}
