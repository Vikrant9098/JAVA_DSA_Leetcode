import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort array to handle duplicates easily
        List<List<Integer>> result = new ArrayList<>(); // List to store all subsets
        backtrack(nums, 0, new ArrayList<>(), result);  // Start backtracking
        return result; // Return final list of subsets
    }

    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList)); // Add current subset to result

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates

            tempList.add(nums[i]);                  // Include current number
            backtrack(nums, i + 1, tempList, result); // Recurse for next elements
            tempList.remove(tempList.size() - 1);  // Backtrack, remove last number
        }
    }
}
