class Solution {
    public int findMin(int[] nums) {
        // Initialize left and right pointers
        int left = 0;
        int right = nums.length - 1;
        
        // Use binary search approach
        while (left < right) {
            // Find middle index
            int mid = left + (right - left) / 2;
            
            // If middle is greater than right, min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // If middle is less than right, min is in left half including mid
            else if (nums[mid] < nums[right]) {
                right = mid;
            } 
            // If middle equals right, reduce right by one to handle duplicates
            else {
                right--;
            }
        }
        
        // Left points to the minimum element
        return nums[left];
    }
}
