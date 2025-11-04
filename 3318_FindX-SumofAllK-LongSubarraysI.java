import java.util.*;  // Import utility classes like Map, List, Arrays, etc.

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {  // Main function to find x-sum for all subarrays
        int n = nums.length;  // Store length of nums array
        int[] ans = new int[n - k + 1];  // Result array to hold x-sum for each subarray
        
        // Loop over all possible subarrays of length k
        for (int i = 0; i <= n - k; i++) {
            // Extract current subarray of length k
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            
            // Count frequency of each number in the subarray
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : sub) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);  // Increment count for each number
            }
            
            // Convert map entries to list for sorting
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});  // Store number and its frequency
            }
            
            // Sort by frequency (desc), then by value (desc)
            list.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];  // Higher frequency first
                return b[0] - a[0];  // If frequency same, larger number first
            });
            
            // Keep only top x most frequent elements
            Set<Integer> keep = new HashSet<>();
            for (int j = 0; j < Math.min(x, list.size()); j++) {
                keep.add(list.get(j)[0]);  // Add top elements to keep set
            }
            
            // Calculate sum of only kept elements in the subarray
            int sum = 0;
            for (int num : sub) {
                if (keep.contains(num)) sum += num;  // Add if number is in top x list
            }
            
            ans[i] = sum;  // Store x-sum for this subarray
        }
        
        return ans;  // Return final array of x-sums
    }
}
