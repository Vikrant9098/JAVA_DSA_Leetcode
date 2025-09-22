import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Store value -> index
        
        for (int i = 0; i < nums.length; i++) 
        {
            int complement = target - nums[i]; // Find the required pair
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Found the pair
            }
            
            map.put(nums[i], i); // Store number and its index
        }
        
        return new int[]{-1, -1}; // No solution found (edge case)
    }
}
