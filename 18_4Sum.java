class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Sort the array to enable two-pointer technique and skip duplicates
        Arrays.sort(nums);
        
        // Store all unique quadruplets
        List<List<Integer>> result = new ArrayList<>();
        
        // Get the length of array
        int n = nums.length;
        
        // First loop: fix the first element
        for (int i = 0; i < n - 3; i++) { // Leave space for 3 more elements
            // Skip duplicate values for first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Second loop: fix the second element
            for (int j = i + 1; j < n - 2; j++) { // Leave space for 2 more elements
                // Skip duplicate values for second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Use two pointers for remaining two elements
                int left = j + 1;
                int right = n - 1;
                
                // Two pointer approach for third and fourth elements
                while (left < right) {
                    // Calculate current sum of four elements (use long to avoid overflow)
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    // If sum equals target, we found a valid quadruplet
                    if (currentSum == target) {
                        // Add the quadruplet to result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for third element
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        
                        // Skip duplicates for fourth element
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        // Move both pointers to find next potential quadruplet
                        left++;
                        right--;
                    }
                    
                    // If sum is less than target, increase sum by moving left pointer
                    else if (currentSum < target) {
                        left++;
                    }
                    
                    // If sum is greater than target, decrease sum by moving right pointer
                    else {
                        right--;
                    }
                }
            }
        }
        
        // Return all unique quadruplets
        return result;
    }
}