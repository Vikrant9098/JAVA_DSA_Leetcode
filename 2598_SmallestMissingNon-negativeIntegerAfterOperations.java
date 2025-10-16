import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // Create a map to count how many times each remainder appears
        Map<Integer, Integer> map = new HashMap<>();
        
        // Loop through each number in nums
        for (int num : nums) {
            // Find remainder after dividing by value (handle negatives too)
            int remainder = ((num % value) + value) % value;
            // Count how many times each remainder appears
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        // Start checking from 0 for smallest missing number
        int mex = 0;
        
        // Keep checking numbers one by one
        while (true) {
            // Find remainder for current mex
            int remainder = mex % value;
            
            // If we still have numbers with this remainder
            if (map.getOrDefault(remainder, 0) > 0) {
                // Use one of them (reduce count)
                map.put(remainder, map.get(remainder) - 1);
                // Move to the next number
                mex++;
            } else {
                // If no number left for this remainder, stop and return mex
                return mex;
            }
        }
    }
}
