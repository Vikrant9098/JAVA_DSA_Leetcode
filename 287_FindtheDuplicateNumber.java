class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Use Floyd's cycle detection to find intersection point
        int slow = nums[0]; // Move one step at a time
        int fast = nums[0]; // Move two steps at a time

        // Find the intersection point in the cycle
        do {
            slow = nums[slow];       // Move slow by 1 step
            fast = nums[nums[fast]]; // Move fast by 2 steps
        } while (slow != fast);       // Stop when they meet

        // Step 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0]; // Move slow back to start
        while (slow != fast) {
            slow = nums[slow]; // Move both one step at a time
            fast = nums[fast];
        }

        return slow; // The point where they meet is the duplicate number
    }
}
