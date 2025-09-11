class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;          // Length of the array
        int left = 0;                 // Left pointer of the sliding window
        int sum = 0;                  // Current window sum
        int minLen = Integer.MAX_VALUE; // Initialize minimum length as infinity

        // Expand the window by moving the right pointer
        for (int right = 0; right < n; right++) {
            sum += nums[right];  // Add current element to the window sum

            // Shrink the window while sum >= target
            while (sum >= target) {
                // Update the minimum length
                minLen = Math.min(minLen, right - left + 1);
                // Shrink window from the left
                sum -= nums[left];
                left++;
            }
        }

        // If no valid subarray found, return 0; otherwise return minLen
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
