import java.util.*; // Import List, ArrayList, Arrays utilities

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // Stores final triplets
        Arrays.sort(nums); // Step 1: Sort the array to use two-pointer technique

        // Step 2: Loop through the array, fixing one number at a time
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate numbers for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; // Pointer just after the fixed number
            int right = nums.length - 1; // Pointer at the end of array

            // Step 3: Use two pointers to find pairs that sum with nums[i] to zero
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // Current triplet sum

                if (sum == 0) {
                    // Found a valid triplet -> add to result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;  // Move left pointer
                    right--; // Move right pointer

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    // Sum too small -> increase it by moving left pointer
                    left++;
                } else {
                    // Sum too big -> decrease it by moving right pointer
                    right--;
                }
            }
        }

        return result; // Return all unique triplets
    }
}
