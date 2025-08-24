class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 'i' points to the last valid element in nums1 (index m-1)
        int i = m - 1;       

        // 'j' points to the last element in nums2 (index n-1)
        int j = n - 1;       

        // 'k' points to the last index of nums1 (size m+n-1), 
        // where we will place the largest element at each step
        int k = m + n - 1;   

        // Merge elements while both arrays still have unprocessed elements
        while (i >= 0 && j >= 0) {
            // Compare the current elements of nums1[i] and nums2[j]
            if (nums1[i] > nums2[j]) {
                // If nums1[i] is larger, place it at nums1[k]
                nums1[k--] = nums1[i--];
            } else {
                // Otherwise, place nums2[j] at nums1[k]
                nums1[k--] = nums2[j--];
            }
        }

        // If any elements are left in nums2, copy them into nums1
        // (No need to handle nums1 because it's already in place)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
