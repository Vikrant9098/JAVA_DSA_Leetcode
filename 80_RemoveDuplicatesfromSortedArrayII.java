class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // if size ≤ 2, no need to remove

        int k = 2; // index to place the next allowed element (first two are always valid)

        for (int i = 2; i < nums.length; i++) {
            // if current num is not equal to element two positions before,
            // it means it appeared less than or equal to twice
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i]; // keep this element
                k++;
            }
        }
        return k; // new length after removing extra duplicates
    }
}
