class Solution {

    // Method to find the maximum sum of a "trionic" subarray
    public long maxSumTrionic(int[] nums) {
        
        // Length of the input array
        int n = nums.length;

        // Initialize result with a very small value (acts like -infinity)
        long res = -1 * (long)1e16;

        // Loop through the array, choosing i as the middle starting point
        // We stop at n-2 because we need space for left and right parts
        for (int i = 1; i < n - 2; i++) {

            // Pointer 'a' will move left from i
            int a = i;

            // Pointer 'b' will move right from i
            int b = i;

            // 'net' stores the sum of the decreasing middle segment
            long net = nums[a];

            // Extend to the right while the array is strictly decreasing
            while (b + 1 < n && nums[b + 1] < nums[b]) {
                // Add the next smaller value to net
                net += (long) nums[b + 1];
                // Move right pointer forward
                b++;
            }

            // If no decreasing segment exists, skip this i
            if (b == a) continue;

            // Store the end of the decreasing segment
            int c = b;

            // Sum of increasing elements on the left
            long left = 0;

            // Sum of increasing elements on the right
            long right = 0;

            // Maximum sum obtainable from the left increasing segment
            long lx = Integer.MIN_VALUE;

            // Maximum sum obtainable from the right increasing segment
            long rx = Integer.MIN_VALUE;

            // Move left while values are strictly increasing
            while (a - 1 >= 0 && nums[a - 1] < nums[a]) {
                // Add the left value to left sum
                left += (long) nums[a - 1];
                // Keep track of the maximum left sum
                lx = Math.max(lx, left);
                // Move left pointer backward
                a--;
            }

            // If no increasing segment on the left, skip
            if (a == i) continue;

            // Move right while values are strictly increasing
            while (b + 1 < n && nums[b + 1] > nums[b]) {
                // Add the right value to right sum
                right += (long) nums[b + 1];
                // Keep track of the maximum right sum
                rx = Math.max(rx, right);
                // Move right pointer forward
                b++;
            }

            // If no increasing segment on the right, skip
            if (b == c) continue;

            // Move i forward to avoid reprocessing overlapping segments
            i = b - 1;

            // Update result with the maximum trionic sum found so far
            // (left increasing + middle decreasing + right increasing)
            res = Math.max(res, lx + rx + net);
        }

        // Return the maximum trionic sum
        return res;
    }
}
