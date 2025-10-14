import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // to store all subsets
        backtrack(0, nums, new ArrayList<>(), result); // start from index 0
        return result; // return all subsets
    }

    // helper function for backtracking
    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // add current subset to result

        // try adding each remaining element
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // include this element
            backtrack(i + 1, nums, current, result); // move to next element
            current.remove(current.size() - 1); // backtrack: remove last element
        }
    }
}
