import java.util.Arrays;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        // Store robots as {position, distance}
        int[][] x = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            x[i][0] = robots[i];   // robot position
            x[i][1] = distance[i]; // shooting distance
        }

        // Sort robots based on position (left → right)
        Arrays.sort(x, 0, n, (a, b) -> a[0] - b[0]);

        // Sort walls for binary search
        Arrays.sort(walls);

        // Add dummy robot at end to avoid bounds checking
        x[n][0] = (int)1e9;
        x[n][1] = 0;

        // lower_bound: first index where value >= target
        java.util.function.BiFunction<int[], Integer, Integer> lowerBound = (arr, target) -> {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] < target) l = mid + 1;
                else r = mid;
            }
            return l;
        };

        // upper_bound: first index where value > target
        java.util.function.BiFunction<int[], Integer, Integer> upperBound = (arr, target) -> {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] <= target) l = mid + 1;
                else r = mid;
            }
            return l;
        };

        // Count number of walls in range [l, r]
        java.util.function.BiFunction<Integer, Integer, Integer> query = (l, r) -> {
            if (l > r) return 0; // invalid range
            int it1 = upperBound.apply(walls, r); // index after r
            int it2 = lowerBound.apply(walls, l); // index at l
            return it1 - it2; // count of walls in range
        };

        // dp[i][0] → max walls till i if robot i shoots LEFT
        // dp[i][1] → max walls till i if robot i shoots RIGHT
        int[][] dp = new int[n][2];

        // Base case for first robot
        dp[0][0] = query.apply(x[0][0] - x[0][1], x[0][0]); // shoot left

        if (n > 1) {
            // shoot right but don't overlap next robot
            dp[0][1] = query.apply(
                x[0][0],
                Math.min(x[1][0] - 1, x[0][0] + x[0][1])
            );
        } else {
            // only one robot
            dp[0][1] = query.apply(x[0][0], x[0][0] + x[0][1]);
        }

        // Process remaining robots
        for (int i = 1; i < n; i++) {

            // Case 1: shoot RIGHT
            // take best of previous and add current right range
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) +
                       query.apply(
                           x[i][0],
                           Math.min(x[i + 1][0] - 1, x[i][0] + x[i][1])
                       );

            // Case 2: shoot LEFT without overlap with previous robot
            dp[i][0] = dp[i - 1][0] +
                       query.apply(
                           Math.max(x[i][0] - x[i][1], x[i - 1][0] + 1),
                           x[i][0]
                       );

            // Case 3: shoot LEFT with overlap correction
            int leftStart = Math.max(x[i][0] - x[i][1], x[i - 1][0] + 1);
            int leftEnd = x[i][0];

            // overlapping region with previous RIGHT shot
            int overlapStart = leftStart;
            int overlapEnd = Math.min(x[i - 1][0] + x[i - 1][1], x[i][0] - 1);

            // subtract overlapping walls to avoid double count
            int res = dp[i - 1][1]
                      + query.apply(leftStart, leftEnd)
                      - query.apply(overlapStart, overlapEnd);

            // take best of both LEFT options
            dp[i][0] = Math.max(dp[i][0], res);
        }

        // Final answer = max of last robot shooting LEFT or RIGHT
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}