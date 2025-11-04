import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;  // length of the array
        int[] sorted = nums.clone();  // make a copy of the array
        Arrays.sort(sorted);  // sort the copy
        
        int mid = (n + 1) / 2;  // find the middle index
        int j = mid - 1;  // pointer for smaller half
        int k = n - 1;    // pointer for larger half
        
        // fill nums in reverse order to avoid overwriting
        for (int i = 0; i < n; i++) {
            // even indices get smaller elements, odd get larger ones
            if (i % 2 == 0) {
                nums[i] = sorted[j--];  // take from smaller half
            } else {
                nums[i] = sorted[k--];  // take from larger half
            }
        }
    }
}
