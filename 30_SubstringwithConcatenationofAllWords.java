import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Result list to store starting indices of valid substrings
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if input string or words list is empty, return empty result
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        // Length of each word (all words are of same length)
        int wordLength = words[0].length();
        // Total number of words
        int wordCount = words.length;
        // Total length of substring we are looking for
        int substringLength = wordLength * wordCount;
        
        // If string is smaller than the required substring length → no possible match
        if (s.length() < substringLength) {
            return result;
        }
        
        // Build frequency map of words (word → count)
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        // Try starting from every offset within wordLength
        // Example: if wordLength = 3, we try indices 0, 1, 2
        for (int i = 0; i < wordLength; i++) {
            int left = i; // Left pointer for current sliding window
            int count = 0; // Number of valid words matched so far
            Map<String, Integer> windowMap = new HashMap<>(); // Tracks words in current window
            
            // Move right pointer in steps of wordLength
            for (int right = i; right + wordLength <= s.length(); right += wordLength) {
                // Extract the word of size wordLength from the current position
                String word = s.substring(right, right + wordLength);
                
                // If the extracted word is one of the required words
                if (wordMap.containsKey(word)) {
                    // Add/update the count of this word in the current window
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // If the word occurs more times than needed, shrink window from the left
                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    
                    // If window contains exactly all words → store the starting index
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // If word not in wordMap, reset the window
                    windowMap.clear();
                    count = 0;
                    left = right + wordLength; // Move left pointer just after current invalid word
                }
            }
        }
        
        // Return all starting indices found
        return result;
    }
}
