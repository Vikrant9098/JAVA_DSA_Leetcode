class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length; // length of first array
        int l2 = nums2.length; // length of second array
        int i = 0, j = 0, k = 0; // pointers for both arrays and result index

        Arrays.sort(nums1); // sort first array
        Arrays.sort(nums2); // sort second array

        // loop until one of the arrays is fully traversed
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) { 
                i++; // move i forward if nums1[i] is smaller
            } 
            else if (nums1[i] > nums2[j]) { 
                j++; // move j forward if nums2[j] is smaller
            } 
            else { 
                nums1[k++] = nums1[i++]; // store the common element and move i, k forward
                j++; // move j forward too
            }
        }

        // return the intersection part of nums1 (from 0 to k)
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
