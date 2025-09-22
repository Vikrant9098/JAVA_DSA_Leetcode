class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store the last index of each number
        Map<Integer, Integer> map = new HashMap<>();
        
        // Loop through array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // If num was seen before and difference of indices <= k
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            
            // Update the index of the current number
            map.put(num, i);
        }
        
        // No valid pair found
        return false;
    }
}
