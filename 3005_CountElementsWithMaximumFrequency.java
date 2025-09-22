import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Create a map to store the frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            // Increment the count of the number in the map
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Find the maximum frequency among all numbers
        int maxFreq = Collections.max(freqMap.values());

        // Variable to store total occurrences of numbers with max frequency
        int total = 0;
        for (int count : freqMap.values()) {
            // If this number has the maximum frequency, add all its occurrences
            if (count == maxFreq) {
                total += count;
            }
        }

        // Return the total frequency count
        return total;
    }
}
