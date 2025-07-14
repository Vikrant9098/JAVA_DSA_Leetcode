class Solution {
    public int longestSubarray(int[] nums) {
        // Initialize the left pointer of the window
        int left = 0;
        // Count of zeros in the current window
        int zeroCount = 0;
        // Maximum length of the subarray after deleting one element
        int maxLength = 0;

        // Traverse the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            // If current element is 0, increase zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If there are more than one zero, shrink window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++; // Move the left pointer forward
            }

            // Calculate the current window size (delete one element → length = right - left)
            maxLength = Math.max(maxLength, right - left);
        }

        // Return the maximum length of valid subarray found
        return maxLength;
    }
}
