class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;  // If less than 2 elements, max gap = 0

        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Find global minimum and maximum in the array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;  // All numbers are the same → max gap = 0

        // Calculate bucket size (at least 1) and number of buckets
        int bucketSize = Math.max(1, (max - min) / (n - 1)); // Minimum possible gap
        int bucketCount = (max - min) / bucketSize + 1;      // Total number of buckets

        int[] bucketMin = new int[bucketCount];              // Store min in each bucket
        int[] bucketMax = new int[bucketCount];              // Store max in each bucket
        Arrays.fill(bucketMin, Integer.MAX_VALUE);          // Initialize min values
        Arrays.fill(bucketMax, Integer.MIN_VALUE);          // Initialize max values

        // Place each number into its corresponding bucket
        for (int num : nums) {
            int idx = (num - min) / bucketSize;             // Bucket index for current number
            bucketMin[idx] = Math.min(bucketMin[idx], num);// Update bucket min
            bucketMax[idx] = Math.max(bucketMax[idx], num);// Update bucket max
        }

        int maxGap = 0;
        int previous = min;                                  // Previous max value to compute gap

        // Compute maximum gap between consecutive non-empty buckets
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue; // Skip empty buckets
            maxGap = Math.max(maxGap, bucketMin[i] - previous); // Gap between buckets
            previous = bucketMax[i];                         // Update previous for next iteration
        }

        return maxGap;                                      // Return the maximum gap
    }
}
