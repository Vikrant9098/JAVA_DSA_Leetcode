import java.util.*; // Import utility classes like PriorityQueue

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3; // Total elements to remove
        int len = nums.length;   // Total length of the array (3n)

        long[] leftSum = new long[len];  // Stores min sum of n smallest elements from left to right
        long[] rightSum = new long[len]; // Stores min sum of n largest elements from right to left

        // Max-heap to keep n smallest elements from the left part
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftTotal = 0; // Sum of elements in the maxHeap

        // Traverse from left to right to compute smallest n elements at each position
        for (int i = 0; i < len; i++) {
            maxHeap.offer(nums[i]);     // Add current number to heap
            leftTotal += nums[i];       // Add to running total

            if (maxHeap.size() > n) {   // If more than n elements, remove largest (max heap)
                leftTotal -= maxHeap.poll();
            }

            if (maxHeap.size() == n) {  // Store sum when exactly n elements collected
                leftSum[i] = leftTotal;
            }
        }

        // Min-heap to keep n largest elements from the right part
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightTotal = 0; // Sum of elements in the minHeap

        // Traverse from right to left to compute largest n elements at each position
        for (int i = len - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);     // Add current number to heap
            rightTotal += nums[i];      // Add to running total

            if (minHeap.size() > n) {   // If more than n elements, remove smallest (min heap)
                rightTotal -= minHeap.poll();
            }

            if (minHeap.size() == n) {  // Store sum when exactly n elements collected
                rightSum[i] = rightTotal;
            }
        }

        long result = Long.MAX_VALUE; // Initialize result to max value

        // Check the difference between leftSum and rightSum in valid ranges
        for (int i = n - 1; i < 2 * n; i++) {
            result = Math.min(result, leftSum[i] - rightSum[i + 1]); // Minimize the difference
        }

        return result; // Return the minimum difference
    }
}
