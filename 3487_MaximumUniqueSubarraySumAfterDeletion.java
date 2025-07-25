import java.util.Arrays;

class Solution {
    public int maxSum(int[] nums) {
        // Step 1: Find the maximum value in the array
        int mx = Arrays.stream(nums).max().getAsInt();

        // Step 2: If all elements are zero or negative, return the maximum (least negative or zero)
        if (mx <= 0) {
            return mx;
        }

        // Step 3: Create a boolean array of size 201 to track if a number has been used
        // We shift by +100 since nums[i] ranges from -100 to 100, to avoid negative indices
        boolean[] s = new boolean[201];

        // Step 4: Initialize answer to 0
        int ans = 0;

        // Step 5: Loop through each number in the array
        for (int x : nums) {
            // If the number is negative or already used, skip it
            if (x < 0 || s[x + 100]) {
                continue;
            }

            // Add the number to the sum
            ans += x;

            // Mark the number as used in the boolean array
            s[x + 100] = true;
        }

        // Step 6: Return the final answer
        return ans;
    }
}
