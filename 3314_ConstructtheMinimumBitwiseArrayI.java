import java.util.List;

class Solution { 
    // Defines the Solution class (required by LeetCode / judge)

    public int[] minBitwiseArray(List<Integer> nums) {
        // Method that takes a list of integers and returns an integer array as result

        int ans[] = new int[nums.size()];
        // Create an array to store the answer for each number in nums

        for (int i = 0; i < nums.size(); i++) {
            // Loop through each index of the input list

            int n = nums.get(i);
            // Get the current number from the list

            if (n != 2)
                // Special case: if the number is NOT equal to 2

                ans[i] = n - ((n + 1) & (-n - 1)) / 2;
                // Core logic:
                // (n + 1)        → shifts to the next number
                // (-n - 1)       → two’s complement trick to isolate lowest zero bit
                // (n + 1) & (-n - 1) → finds the lowest unset (0) bit in n
                // Divide by 2    → adjusts the bit position
                // Subtract from n → produces the minimum number whose OR gives n

            else
                // Special handling for n == 2 (edge case)

                ans[i] = -1;
                // No valid answer exists for n = 2, so store -1
        }  

        return ans;
        // Return the final result array
    }
}
