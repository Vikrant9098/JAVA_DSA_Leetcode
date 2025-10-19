import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Result list to store all unique combinations
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort candidates to handle duplicates easily
        Arrays.sort(candidates);

        // Call backtracking helper
        backtrack(result, new ArrayList<>(), candidates, target, 0);

        // Return final result
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If target becomes zero, we found a valid combination
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Loop through candidates starting from current index
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate numbers to avoid repeating combinations
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If current number exceeds remaining target, stop the loop
            if (candidates[i] > remain) break;

            // Choose current number
            tempList.add(candidates[i]);

            // Move to next index (each number used once)
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);

            // Backtrack (remove last chosen number)
            tempList.remove(tempList.size() - 1);
        }
    }
}
