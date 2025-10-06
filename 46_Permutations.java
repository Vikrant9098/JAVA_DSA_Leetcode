import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // Stores all permutations
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]); // Start recursion
        return result; // Return all generated permutations
    }

    // Helper function to generate permutations using backtracking
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // Base condition: if the permutation has all numbers
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of the current permutation
            return;
        }

        // Try each number in nums
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip if this number is already used
            used[i] = true; // Mark as used
            tempList.add(nums[i]); // Choose the number
            backtrack(result, tempList, nums, used); // Recurse to build the next position
            tempList.remove(tempList.size() - 1); // Undo the choice (backtrack)
            used[i] = false; // Mark as unused again
        }
    }
}
