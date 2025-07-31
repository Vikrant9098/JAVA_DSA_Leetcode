import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // Set to store all unique OR results
        Set<Integer> result = new HashSet<>();

        // Set to store OR results of subarrays ending at previous element
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            // Set to store OR results of subarrays ending at current element
            Set<Integer> curr = new HashSet<>();

            // Add current number itself as a subarray
            curr.add(num);

            // Extend previous subarrays by ORing with current number
            for (int val : prev) {
                curr.add(val | num);
            }

            // Add all current results to the final result
            result.addAll(curr);

            // Update prev for next iteration
            prev = curr;
        }

        return result.size();
    }
}
