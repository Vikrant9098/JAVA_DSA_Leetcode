import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        // t = stores slopes (normalized sign) → lines grouped by intercept
        HashMap<Integer, HashMap<Integer, Integer>> t = new HashMap<>();
        // v = stores raw direction → used to remove parallelograms
        HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();

        int n = points.length; // total number of points

        for (int i = 0; i < n; i++) {                 // pick point i
            for (int j = i + 1; j < n; j++) {         // pick point j

                int dx = points[j][0] - points[i][0]; // x difference
                int dy = points[j][1] - points[i][1]; // y difference

                // make slope direction consistent (avoid duplicates)
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                // find gcd to reduce slope
                int g = gcd(dx, Math.abs(dy));
                int sx = dx / g;   // reduced dx (slope x part)
                int sy = dy / g;   // reduced dy (slope y part)

                // compute line intercept value for grouping
                int des = sx * points[i][1] - sy * points[i][0];

                // key1 = unique key for slope using reduced slope
                int key1 = (sx << 12) | (sy + 2000);
                // key2 = key for raw direction (used for parallelograms)
                int key2 = (dx << 12) | (dy + 2000);

                // add to map t → count how many lines share same slope + intercept
                t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
                // add to map v → used to count parallelograms
                v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
            }
        }

        // trapezoids = all parallel line-pairs minus parallelograms
        return count(t) - count(v) / 2;
    }

    private int count(HashMap<Integer, HashMap<Integer, Integer>> map) {
        long ans = 0; // total count

        for (HashMap<Integer, Integer> inner : map.values()) { // for each slope
            long sum = 0;

            for (int val : inner.values()) sum += val; // total lines

            for (int val : inner.values()) {
                sum -= val;           // remove current line’s count
                ans += (long) val * sum; // count combinations (val * remaining)
            }
        }

        return (int) ans; // return total found
    }

    private int gcd(int a, int b) {
        while (b != 0) {   // standard gcd loop
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a); // return positive gcd
    }
}
