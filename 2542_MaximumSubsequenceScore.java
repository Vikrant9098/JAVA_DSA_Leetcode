class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length; // Get the length of the input arrays

        // Create a 2D array to store pairs of (nums1[i], nums2[i])
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i]; // First element of pair is nums1[i]
            pairs[i][1] = nums2[i]; // Second element of pair is nums2[i]
        }

        // Sort the pairs in descending order by nums2[i] (second value of each pair)
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        // Min-heap to store the top k elements from nums1 (to maintain largest sum)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;        // To keep the sum of top k nums1 values
        long maxScore = 0;   // To track the maximum score

        // Iterate through each sorted pair
        for (int i = 0; i < n; i++) {
            int val1 = pairs[i][0]; // Current nums1[i]
            int val2 = pairs[i][1]; // Current nums2[i]

            sum += val1;            // Add current nums1[i] to the running sum
            minHeap.offer(val1);    // Add nums1[i] to the min-heap

            // If heap size exceeds k, remove the smallest element and subtract from sum
            if (minHeap.size() > k) {
                sum -= minHeap.poll(); // Remove the smallest nums1[i] to maintain only top k
            }

            // If we have exactly k elements, calculate the score
            if (minHeap.size() == k) {
                long score = sum * val2; // Score = sum of selected nums1 * current nums2 (min in selection)
                maxScore = Math.max(maxScore, score); // Update maxScore if current score is higher
            }
        }

        return maxScore; // Return the highest score found
    }
}
