class Solution {
    public int minOperations(int[] nums, int k) {

        int ans = 0, n = nums.length;   // ans = total sum, n = size of array

        for (int i = 0; i < n; i++)      // loop through all elements
            ans += nums[i];              // add each element to total sum

        return ans % k;                  // return remainder → operations needed
    }
}
