import java.util.Arrays;
    /**
     * Return the minimum number of removals to make the array balanced.
     * An array is balanced if for every index i, nums[i] * k >= nums[j] for all j.
     * @param nums the input array
     * @param k the balance factor
     * @return the minimum number of removals to make the array balanced
     */

class Solution {
    public int minRemoval(int[] nums, int k) {
        // Sort the array to use sliding window
        Arrays.sort(nums);

        // Left pointer of the window
        int i = 0;

        // Stores the maximum valid window size
        int maxLen = 0;

        // Right pointer moves through the array
        for (int j = 0; j < nums.length; j++) {

            // Shrink window if condition nums[j] > nums[i] * k breaks
            // long is used to avoid overflow
            while ((long) nums[j] > (long) nums[i] * k) {
                // Move left pointer to make window valid again
                i++;
            }

            // Update maximum valid window size
            maxLen = Math.max(maxLen, j - i + 1);
        }

        // Minimum removals = total elements - largest valid group
        return nums.length - maxLen;
    }
}
