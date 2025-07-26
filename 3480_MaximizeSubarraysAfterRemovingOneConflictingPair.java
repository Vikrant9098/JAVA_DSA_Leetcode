import java.util.*;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] groups = new ArrayList[n + 2];
        for (int i = 0; i <= n + 1; i++) {
            groups[i] = new ArrayList<>();
        }
        // Bucket R values by L = min(a,b)
        for (int[] p : conflictingPairs) {
            int a = p[0], b = p[1];
            if (a > b) { int t = a; a = b; b = t; }
            groups[a].add(b);
        }

        long base = 0;
        long[] gain = new long[n + 2];
        int minR0 = n + 1, minR1 = n + 1;

        // Sweep from rightmost to leftmost (a = n down to 1)
        for (int a = n; a >= 1; a--) {
            // merge new Rs from groups[a]
            for (int r : groups[a]) {
                if (r < minR0) {
                    minR1 = minR0;
                    minR0 = r;
                } else if (r < minR1) {
                    minR1 = r;
                }
            }
            // count valid subarrays starting at a: those ending before minR0
            base += (minR0 - a);
            // if we remove conflict with R = minR0, gain is (minR1 - minR0)
            gain[minR0] += (minR1 - minR0);
        }

        // best removal gives additional gain
        long bestGain = 0;
        for (long g : gain) bestGain = Math.max(bestGain, g);

        return base + bestGain;
    }
}
