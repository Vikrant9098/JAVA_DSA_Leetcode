import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // Stores all valid combinations
        backtrack(result, new ArrayList<>(), candidates, target, 0); // Start recursion
        return result; // Return the final list of combinations
    }

    // Helper function for backtracking
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If remaining sum is less than 0, stop exploring this path
        if (remain < 0) return;
        
        // If remaining sum is 0, we found a valid combination
        if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Add a copy of current combination
            return;
        }

        // Loop through candidates starting from 'start' to allow repeated usage
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]); // Choose current number
            // Recurse with updated remaining sum (same i to reuse the number)
            backtrack(result, tempList, candidates, remain - candidates[i], i);
            tempList.remove(tempList.size() - 1); // Undo choice (backtrack)
        }
    }
}
