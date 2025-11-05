import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        // Create a list to store the result pairs
        List<List<Integer>> result = new ArrayList<>();

        // Create a map to store reversed word → its index
        Map<String, Integer> map = new HashMap<>();

        // Store all reversed words in the map
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        // Go through each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i]; // current word

            // Try splitting the word at every position
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);   // left part
                String right = word.substring(j);     // right part

                // If left part is palindrome
                if (isPalindrome(left)) {
                    // Find reversed right part in map
                    Integer idx = map.get(right);
                    // If found and not same word
                    if (idx != null && idx != i) {
                        // Add pair (reversed right index, current word index)
                        result.add(Arrays.asList(idx, i));
                    }
                }

                // If right part is palindrome
                if (j != word.length() && isPalindrome(right)) {
                    // Find reversed left part in map
                    Integer idx = map.get(left);
                    // If found and not same word
                    if (idx != null && idx != i) {
                        // Add pair (current word index, reversed left index)
                        result.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        // Return all palindrome pairs
        return result;
    }

    // Check if a string is palindrome
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1; // pointers at both ends
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false; // mismatch → not palindrome
        }
        return true; // all matched → palindrome
    }
}
