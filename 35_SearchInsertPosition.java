class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;                  // start of array
        int right = nums.length - 1;   // end of array
        
        // binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;  // middle index
            
            if (nums[mid] == target) {  // target found
                return mid;
            } else if (nums[mid] < target) {  // target in right half
                left = mid + 1;
            } else {                        // target in left half
                right = mid - 1;
            }
        }
        
        // target not found, left is the insert position
        return left;
    }
}
