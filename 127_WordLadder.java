import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the word list to a set for quick lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // If the end word is not in the dictionary, no transformation is possible
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Queue for BFS: each element is a pair (word, level)
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Keep track of visited words to prevent revisiting
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1; // Start from level 1 (beginWord)

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process each word in the current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // If we found the endWord, return the level (sequence length)
                if (word.equals(endWord)) {
                    return level;
                }

                // Try changing each character in the word
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    // Try all 26 possible lowercase letters
                    for (char c = 'a'; c <= 'z'; c++) {
                        // Skip if same character
                        if (chars[j] == c) continue;

                        // Mutate the character
                        chars[j] = c;
                        String newWord = new String(chars);

                        // If new word is valid and not visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            // Increase level after processing one full layer of BFS
            level++;
        }

        // If transformation not possible
        return 0;
    }
}
