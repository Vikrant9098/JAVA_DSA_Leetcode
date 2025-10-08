class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make sure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Lengths of arrays
        int m = nums1.length;
        int n = nums2.length;
        // Binary search boundaries
        int left = 0, right = m;

        // Binary search loop
        while (left <= right) {
            // Partition index for nums1
            int partition1 = (left + right) / 2;
            // Partition index for nums2 so that left half has same total elements
            int partition2 = (m + n + 1) / 2 - partition1;

            // Edge case handling: if partition is at the start or end
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if partitions are correct
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Total length even: median is average of max left and min right
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } 
                // Total length odd: median is max of left halves
                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } 
            // If left max of nums1 is too big, move partition left
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } 
            // If left max of nums2 is too big, move partition right
            else {
                left = partition1 + 1;
            }
        }

        // If arrays are not sorted properly
        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }
}
