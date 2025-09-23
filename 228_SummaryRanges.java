import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        // List to store the result ranges
        List<String> result = new ArrayList<>();

        // If array is empty, return empty result
        if (nums.length == 0) return result;

        // Mark the start of the current range
        int start = nums[0];

        // Loop through all numbers
        for (int i = 1; i <= nums.length; i++) {
            // Case 1: reached the end of array
            // Case 2: current number is not consecutive to previous one
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // If start and end are the same number, add single value
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    // Otherwise, add range "start->end"
                    result.add(start + "->" + nums[i - 1]);
                }
                // Update start for the next range (if not at the end)
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        // Return the final list of ranges
        return result;
    }
}
