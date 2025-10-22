import java.util.*; // Import utilities

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) { // Function definition
        int n = nums.length; // Store length of array

        Map<Long, Integer> count = new HashMap<>(); // Map to count frequency of each number
        for (int v : nums) { // Loop through array
            count.put((long)v, count.getOrDefault((long)v, 0) + 1); // Increment count for each value
        }

        TreeMap<Long, Long> diff = new TreeMap<>(); // TreeMap to store range changes for sweep line
        for (int v : nums) { // Loop through all numbers
            long vL = (long)v - k; // Left boundary of range
            long vR = (long)v + k; // Right boundary of range
            diff.put(vL, diff.getOrDefault(vL, 0L) + 1); // Start of interval adds 1
            diff.put(vR + 1, diff.getOrDefault(vR + 1, 0L) - 1); // End of interval subtracts 1
            diff.put((long)v, diff.getOrDefault((long)v, 0L) + 0L); // Ensure actual value exists in map
        }

        long s = 0; // Running sum for how many elements can reach current x
        int ans = 1; // Variable to store max frequency

        for (Map.Entry<Long, Long> entry : diff.entrySet()) { // Traverse sorted map
            long x = entry.getKey(); // Current target value
            long delta = entry.getValue(); // Change in count at this point
            s += delta; // Update running total of reachable elements
            int cntX = count.getOrDefault(x, 0); // Count of elements already equal to x
            int possible = (int)Math.min(s, (long)cntX + numOperations); // Max we can make equal to x
            ans = Math.max(ans, possible); // Update max frequency if larger
        }

        return ans; // Return result
    }
}
