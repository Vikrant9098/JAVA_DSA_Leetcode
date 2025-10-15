class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(); // get size of list
        int up = 1; // current increasing length
        int pre_max_up = 0; // previous increasing length
        int res = 0; // result for max k

        for (int i = 1; i < n; ++i) { // loop from 2nd element
            if (nums.get(i) > nums.get(i - 1)) { // if strictly increasing
                up++; // extend current increasing length
            } else { // sequence breaks
                pre_max_up = up; // store previous increasing length
                up = 1; // reset current length
            }
            // find possible k using current and previous sequences
            res = Math.max(res, Math.max(up / 2, Math.min(pre_max_up, up)));
        }

        return res; // return the max k found
    }
}
