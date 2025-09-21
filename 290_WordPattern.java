import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");  // Split the string into words
        if (pattern.length() != words.length) return false;  // Length mismatch → cannot follow pattern

        Map<Character, String> charToWord = new HashMap<>();  // Map pattern char → word
        Map<String, Character> wordToChar = new HashMap<>();  // Map word → pattern char

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            // If character already mapped, check if mapping matches the current word
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) return false;  // Mismatch → false
            } else {
                charToWord.put(c, w);  // Add new mapping
            }

            // If word already mapped, check if mapping matches the current character
            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != c) return false;  // Mismatch → false
            } else {
                wordToChar.put(w, c);  // Add new mapping
            }
        }

        return true;  // All mappings are consistent → pattern matches
    }
}
