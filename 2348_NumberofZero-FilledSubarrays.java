class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;   // total zero-filled subarrays
        long streak = 0;  // current consecutive zero streak

        for (int num : nums) {
            if (num == 0) {
                streak++;      // extend zero streak
                count += streak; // add all subarrays ending here
            } else {
                streak = 0;    // reset if non-zero
            }
        }

        return count;
    }
}
