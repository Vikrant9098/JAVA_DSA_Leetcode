import java.util.*;  // import utility classes for List, ArrayList, PriorityQueue, Arrays

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();  // store final pairs
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result; // edge case check

        // Min-heap to store pairs with their sum
        // Each element = [sum of pair, index in nums1, index in nums2]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initially, pair first element of nums2 with each element of nums1 (up to k elements)
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0}); // push sum and indexes into heap
        }

        // Extract k smallest pairs from the heap
        while (k > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();  // remove the pair with the smallest sum
            int i = top[1], j = top[2];  // get indexes of nums1 and nums2
            result.add(Arrays.asList(nums1[i], nums2[j]));  // add the actual pair to result list
            k--;  // one pair has been used

            // If next element exists in nums2, push new pair with same nums1[i] and next nums2[j+1]
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;  // return the final list of k smallest pairs
    }
}
