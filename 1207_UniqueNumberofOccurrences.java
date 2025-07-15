import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> occurrenceSet = new HashSet<>();

        // Count the occurrences of each number
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Check if occurrences are unique
        for (int count : countMap.values()) {
            if (!occurrenceSet.add(count)) {
                return false; // Duplicate occurrence count found
            }
        }

        return true; // All occurrence counts are unique
    }
}
