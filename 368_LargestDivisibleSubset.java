import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort numbers to make divisibility check easier
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];            // dp[i] = size of largest subset ending at nums[i]
        int[] prev = new int[n];          // prev[i] = previous index in subset
        Arrays.fill(dp, 1);               // each number alone is a subset of size 1
        Arrays.fill(prev, -1);            // no previous element at start

        int maxIndex = 0;                 // index of last element in largest subset

        // Loop through each number
        for (int i = 1; i < n; i++) {
            // Check all smaller numbers
            for (int j = 0; j < i; j++) {
                // If divisible and gives bigger subset
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;    // update subset size
                    prev[i] = j;           // store previous index
                }
            }
            // Update largest subset end index
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Create list to store result
        List<Integer> result = new ArrayList<>();
        int k = maxIndex;                 // start from largest subset end
        while (k >= 0) {
            result.add(nums[k]);          // add current number
            k = prev[k];                  // move to previous element
        }

        Collections.reverse(result);      // reverse to get correct order
        return result;                    // return final subset
    }
}
