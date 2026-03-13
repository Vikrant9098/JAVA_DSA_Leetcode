class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long lo = 1, hi = 10000000000000000L; // search range for minimum time

        while (lo < hi) {
            long mid = (lo + hi) >> 1; // middle time (binary search)
            long tot = 0; // total height workers can reduce in 'mid' seconds

            for (int i = 0; i < times.length && tot < height; i++)
                // compute max units this worker can complete in 'mid' time
                // derived from solving k*(k+1)/2 * times[i] <= mid
                tot += (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);

            if (tot >= height)
                hi = mid; // possible answer, try smaller time
            else
                lo = mid + 1; // not enough work done, increase time
        }

        return lo; // minimum seconds needed
    }
}