import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // To store all unique permutations
        Arrays.sort(nums);  // Sort to easily skip duplicates
        boolean[] used = new boolean[nums.length];  // Track which elements are already used
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: if current list size equals nums length, we found a permutation
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));  // Add a copy of the current permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (used[i]) continue;

            // Skip duplicates: if current element is same as previous and previous was not used, skip it
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Choose the current element
            used[i] = true;
            current.add(nums[i]);

            // Explore further
            backtrack(nums, current, used, result);

            // Backtrack (undo the choice)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
