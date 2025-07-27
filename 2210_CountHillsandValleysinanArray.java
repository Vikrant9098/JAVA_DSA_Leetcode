class Solution {
    public int countHillValley(int[] nums) {
        // Step 1: Remove consecutive duplicates
        List<Integer> cleaned = new ArrayList<>();
        cleaned.add(nums[0]); // Always add the first element

        for (int i = 1; i < nums.length; i++) {
            // Only add if current is not same as previous
            if (nums[i] != nums[i - 1]) {
                cleaned.add(nums[i]);
            }
        }

        // Step 2: Count hills and valleys in the cleaned list
        int count = 0;

        // Iterate from 1 to length - 2, because hills/valleys need both neighbors
        for (int i = 1; i < cleaned.size() - 1; i++) {
            int prev = cleaned.get(i - 1); // Left neighbor
            int curr = cleaned.get(i);     // Current element
            int next = cleaned.get(i + 1); // Right neighbor

            // Hill: current is greater than both neighbors
            if (curr > prev && curr > next) {
                count++;
            }
            // Valley: current is less than both neighbors
            else if (curr < prev && curr < next) {
                count++;
            }
        }

        return count; // Return the final count of hills and valleys
    }
}
