class Solution {
    // Variable to store the maximum OR value found from any subset
    int maxOr = 0;

    // Variable to count the number of subsets whose OR equals maxOr
    int count = 0;

    // Main method to count subsets with maximum OR value
    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the maximum OR value possible from any subset
        for (int num : nums) {
            maxOr |= num; // Bitwise OR accumulation to get the overall max possible OR
        }

        // Step 2: Use backtracking to explore all subsets starting from index 0 with OR = 0
        backtrack(nums, 0, 0);

        // Return the count of subsets that produce the max OR value
        return count;
    }

    // Recursive backtracking method to explore all subsets
    private void backtrack(int[] nums, int index, int currentOr) {
        // Base case: when we've considered all elements
        if (index == nums.length) {
            // If the OR of the current subset equals the maxOr, increment the count
            if (currentOr == maxOr) {
                count++;
            }
            return; // Return to explore other subsets
        }

        // Recursive case 1: Include the current number in the subset
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Recursive case 2: Exclude the current number from the subset
        backtrack(nums, index + 1, currentOr);
    }
}
