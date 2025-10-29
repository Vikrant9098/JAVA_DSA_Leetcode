import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;  // counts for two candidates
        Integer candidate1 = null, candidate2 = null;  // possible majority elements
        
        // Step 1: find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;  // same as candidate1, increase count1
            } else if (candidate2 != null && num == candidate2) {
                count2++;  // same as candidate2, increase count2
            } else if (count1 == 0) {
                candidate1 = num;  // new candidate1
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;  // new candidate2
                count2 = 1;
            } else {
                count1--;  // decrease both counts
                count2--;
            }
        }

        // Step 2: check real counts of both candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;  // count candidate1
            else if (num == candidate2) count2++;  // count candidate2
        }

        // Step 3: add valid candidates to result
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);  // candidate1 appears enough times
        if (count2 > n / 3) result.add(candidate2);  // candidate2 appears enough times

        return result;  // return list of majority elements
    }
}
