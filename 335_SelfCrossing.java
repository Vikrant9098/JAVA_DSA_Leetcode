class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length; // total number of moves

        // loop through moves starting from the 4th
        for (int i = 3; i < n; i++) {
            
            // case 1: current line crosses the line 3 steps before
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true; // path crosses
            }

            // case 2: current line overlaps with the line 4 steps before
            if (i >= 4 && distance[i - 1] == distance[i - 3] &&
                distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true; // path overlaps
            }

            // case 3: current line crosses the line 5 steps before
            if (i >= 5 && distance[i - 2] >= distance[i - 4] && // line 2 before is long enough
                distance[i - 1] <= distance[i - 3] && // previous line short enough
                distance[i - 1] + distance[i - 5] >= distance[i - 3] && // backward check
                distance[i] + distance[i - 4] >= distance[i - 2]) { // forward check
                return true; // path crosses again
            }
        }

        return false; // no crossing found
    }
}
