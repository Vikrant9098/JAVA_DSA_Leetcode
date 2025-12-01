class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long sum = 0;                      // store total battery power
        for (int b : batteries) sum += b;  // add all battery capacities

        long left = 0, right = sum / n;    // maximum possible time = total power divided among n computers

        // binary search for the maximum possible running time
        while (left < right) {
            long mid = (left + right + 1) / 2;  // try middle time (upper mid to avoid infinite loop)

            // check if we can run all computers for 'mid' minutes
            if (canRun(mid, n, batteries))
                left = mid;               // mid is possible → move search to right half
            else
                right = mid - 1;          // mid is not possible → move to left half
        }

        return left;                      // left will be the maximum valid running time
    }

    private boolean canRun(long time, int n, int[] batteries) {

        long total = 0;                   // total usable power for this time

        for (int b : batteries) {
            total += Math.min(b, time);   // each battery contributes at most 'time' power
        }

        // if total usable power is enough for n computers running for 'time' minutes
        return total >= (long) n * time;  
    }
}
