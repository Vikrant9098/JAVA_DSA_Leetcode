class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create sets to store unique elements from both arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add all elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Add all elements from nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Find elements only in nums1 (not in nums2)
        List<Integer> onlyInNums1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                onlyInNums1.add(num);
            }
        }
        
        // Find elements only in nums2 (not in nums1)
        List<Integer> onlyInNums2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                onlyInNums2.add(num);
            }
        }
        
        // Return the result as a list of two lists
        return Arrays.asList(onlyInNums1, onlyInNums2);
    }
}

/*
 * Alternative concise solution using set operations:
 * 
 * class Solution {
 *     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
 *         Set<Integer> set1 = new HashSet<>();
 *         Set<Integer> set2 = new HashSet<>();
 *         
 *         // Convert arrays to sets
 *         for (int num : nums1) set1.add(num);
 *         for (int num : nums2) set2.add(num);
 *         
 *         // Create copies for difference operations
 *         Set<Integer> diff1 = new HashSet<>(set1);
 *         Set<Integer> diff2 = new HashSet<>(set2);
 *         
 *         // Remove common elements
 *         diff1.removeAll(set2);  // Elements only in nums1
 *         diff2.removeAll(set1);  // Elements only in nums2
 *         
 *         return Arrays.asList(new ArrayList<>(diff1), new ArrayList<>(diff2));
 *     }
 * }
 */

/*
 * Time Complexity: O(N + M)
 * - N is the length of nums1, M is the length of nums2
 * - Creating sets takes O(N) + O(M) time
 * - Finding differences takes O(N) + O(M) time
 * - Total: O(N + M)
 * 
 * Space Complexity: O(N + M)
 * - Two HashSets to store unique elements from both arrays
 * - Two ArrayList to store the result
 * - Total: O(N + M)
 */