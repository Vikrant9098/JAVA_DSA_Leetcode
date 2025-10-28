import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements
        Set<Integer> set = new HashSet<>();

        // Loop through each number in the array
        for (int num : nums) {
            // If the number already exists in the set, it's a duplicate
            if (set.contains(num)) {
                return true; // duplicate found
            }
            // Otherwise, add the number to the set
            set.add(num);
        }

        // If loop finishes, no duplicates were found
        return false;
    }
}
