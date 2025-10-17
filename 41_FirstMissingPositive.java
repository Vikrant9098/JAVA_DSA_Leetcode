class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length; // length of the array

        // place each number in its correct position (nums[i] -> nums[nums[i]-1])
        for (int i = 0; i < n; i++) {
            // while current number is positive, ≤ n, and not in correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1]; // store the number at target position
                nums[nums[i] - 1] = nums[i]; // place current number in correct position
                nums[i] = temp; // put the displaced number at current index
            }
        }

        // find the first index where the number is incorrect
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // first missing positive number
            }
        }

        // if all numbers are in place, the missing number is n+1
        return n + 1;
    }
}
