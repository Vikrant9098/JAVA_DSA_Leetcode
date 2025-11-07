class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length; // number of cities

        long[] power = new long[n]; // to store power of each city
        long window = 0; // current sum of stations in range
        int windowSize = 2 * r + 1; // total range length for each city

        // calculate initial window sum for the first (r+1) cities
        for (int j = 0; j <= Math.min(n - 1, r); j++) 
            window += stations[j];

        // use sliding window to find total power for every city
        for (int i = 0; i < n; i++) {
            power[i] = window; // store total power for city i

            int removeIdx = i - r; // index going out of range
            if (removeIdx >= 0) 
                window -= stations[removeIdx]; // remove it from window

            int addIdx = i + r + 1; // index entering into range
            if (addIdx < n) 
                window += stations[addIdx]; // add it to window
        }

        // binary search on answer (maximum minimum power possible)
        long low = 0;
        long high = Arrays.stream(power).max().orElse(0L) + k; // upper bound for search
        long best = 0; // store best result found

        while (low <= high) {
            long mid = low + (high - low) / 2; // guess a minimum power
            if (canReach(power, r, k, mid)) { // check if possible
                best = mid; // update best answer
                low = mid + 1; // try for higher value
            } else {
                high = mid - 1; // try smaller value
            }
        }
        return best; // final maximum minimum power
    }

    // helper function to check if we can reach 'target' power in all cities
    private boolean canReach(long[] power, int r, long k, long target) {
        int n = power.length; // number of cities
        long used = 0L; // stations used so far
        long[] diff = new long[n + 1]; // difference array for range updates
        long curAdd = 0L; // current additional stations effect

        for (int i = 0; i < n; i++) {
            curAdd += diff[i]; // apply previous additions to current city
            long total = power[i] + curAdd; // total power after additions

            if (total < target) { // if city power is below target
                long need = target - total; // stations needed
                used += need; // update used count
                if (used > k) return false; // not enough stations left

                curAdd += need; // apply this addition
                int end = Math.min(n, i + 2 * r + 1); // find end of affected range
                diff[end] -= need; // mark where this addition stops
            }
        }
        return true; // all cities reached at least target power
    }
}
