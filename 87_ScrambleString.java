import java.util.*;

class Solution {
    public boolean isScramble(String s1, String s2) {
        // If both strings are same, return true
        if (s1.equals(s2)) return true;

        // If lengths are not equal, return false
        if (s1.length() != s2.length()) return false;

        // Map to store already checked string pairs
        Map<String, Boolean> memo = new HashMap<>();

        // Call helper function with memoization
        return helper(s1, s2, memo);
    }

    private boolean helper(String s1, String s2, Map<String, Boolean> memo) {
        // Create a unique key for both strings
        String key = s1 + "," + s2;

        // If already computed, return stored result
        if (memo.containsKey(key)) return memo.get(key);

        // If both strings are same, store and return true
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }

        // If letters don’t match, return false
        if (!isAnagram(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length(); // Get string length

        // Try all possible split points
        for (int i = 1; i < n; i++) {
            // Case 1: No swap between parts
            if (helper(s1.substring(0, i), s2.substring(0, i), memo) &&
                helper(s1.substring(i), s2.substring(i), memo)) {
                memo.put(key, true); // Store result
                return true; // Found valid scramble
            }

            // Case 2: Swap between parts
            if (helper(s1.substring(0, i), s2.substring(n - i), memo) &&
                helper(s1.substring(i), s2.substring(0, n - i), memo)) {
                memo.put(key, true); // Store result
                return true; // Found valid scramble
            }
        }

        // No valid split found, store and return false
        memo.put(key, false);
        return false;
    }

    // Check if two strings have same letters
    private boolean isAnagram(String s1, String s2) {
        char[] c1 = s1.toCharArray(); // Convert s1 to char array
        char[] c2 = s2.toCharArray(); // Convert s2 to char array
        Arrays.sort(c1); // Sort first array
        Arrays.sort(c2); // Sort second array
        return Arrays.equals(c1, c2); // Compare sorted arrays
    }
}
