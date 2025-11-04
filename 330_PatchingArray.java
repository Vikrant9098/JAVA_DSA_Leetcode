class Solution {
    public int minPatches(int[] nums, int n) {
        // variable to store number of patches added
        int patches = 0;
        // index to traverse nums array
        int i = 0;
        // variable to track current reachable range
        long miss = 1; // start from 1 (smallest number we need to cover)

        // loop until we can cover all numbers up to n
        while (miss <= n) {
            // if current number in nums can help extend range
            if (i < nums.length && nums[i] <= miss) {
                // add nums[i] to range
                miss += nums[i];
                // move to next element in nums
                i++;
            } else {
                // otherwise, patch the number 'miss' itself
                miss += miss;
                // increment patch count
                patches++;
            }
        }

        // return total number of patches added
        return patches;
    }
}
