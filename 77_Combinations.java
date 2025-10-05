import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>(); // List to store all combinations
        backtrack(1, n, k, new ArrayList<>(), result); // Start backtracking from 1
        return result;
    }

    // Helper method for backtracking
    private void backtrack(int start, int n, int k, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == k) { // If current combination size equals k
            result.add(new ArrayList<>(tempList)); // Add a copy to result
            return;
        }
        for (int i = start; i <= n; i++) { // Loop through numbers from start to n
            tempList.add(i); // Add current number to combination
            backtrack(i + 1, n, k, tempList, result); // Recurse with next number
            tempList.remove(tempList.size() - 1); // Backtrack, remove last number
        }
    }
}
