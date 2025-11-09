class Solution {
    public int wiggleMaxLength(int[] nums) {
        // if array has 0 or 1 element, return its length (already a wiggle)
        if (nums.length < 2) return nums.length;

        int up = 1;   // longest wiggle subsequence ending with an increase
        int down = 1; // longest wiggle subsequence ending with a decrease

        // loop through the array from the 2nd element
        for (int i = 1; i < nums.length; i++) {
            // if current number is greater than previous (up movement)
            if (nums[i] > nums[i - 1]) {
                up = down + 1; // extend previous down sequence by 1
            }
            // if current number is smaller than previous (down movement)
            else if (nums[i] < nums[i - 1]) {
                down = up + 1; // extend previous up sequence by 1
            }
            // if equal, do nothing (no change in direction)
        }

        // return the longer sequence between up and down
        return Math.max(up, down);
    }
}
