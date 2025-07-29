class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // To track the last index where each bit (0 to 31) was seen
        int[] lastSeen = new int[32];

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // For current number, update the last seen index of all bits set in it
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastSeen[b] = i;
                }
            }

            // Find the farthest index we need to include to get max OR
            int maxEnd = i;
            for (int b = 0; b < 32; b++) {
                maxEnd = Math.max(maxEnd, lastSeen[b]);
            }

            // Minimum subarray length = maxEnd - i + 1
            answer[i] = maxEnd - i + 1;
        }

        return answer;
    }
}
