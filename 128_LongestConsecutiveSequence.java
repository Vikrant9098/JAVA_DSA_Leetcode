class Solution {
    public int longestConsecutive(int[] nums) {
        // Use a HashSet to store all numbers (fast lookup in O(1))
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Add each number into the set
        }

        int longest = 0; // To keep track of the longest sequence length

        // Loop through each number in the set
        for (int num : set) {
            // Check if this number could be the start of a sequence
            // (Only start if num-1 is not in the set)
            if (!set.contains(num - 1)) {
                int currentNum = num; // Current number in the sequence
                int currentStreak = 1; // Start with length 1

                // Keep checking the next consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;       // Move to next number
                    currentStreak++;    // Increase sequence length
                }

                // Update the longest streak found so far
                longest = Math.max(longest, currentStreak);
            }
        }

        // Return the length of the longest consecutive sequence
        return longest;
    }
}
