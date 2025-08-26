class Solution {
    public int jump(int[] nums) {
        int jumps = 0;        // number of jumps made
        int currentEnd = 0;   // end of the range we can reach with current number of jumps
        int farthest = 0;     // farthest index we can reach in current range

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
