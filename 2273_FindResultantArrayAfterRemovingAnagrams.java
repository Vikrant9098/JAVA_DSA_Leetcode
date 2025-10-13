import java.util.*; // Import utility classes like List and Arrays

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>(); // Create a list to store final words
        result.add(words[0]); // Add the first word to the result list
        
        for (int i = 1; i < words.length; i++) { // Loop through all words starting from index 1
            char[] prev = result.get(result.size() - 1).toCharArray(); // Get last word from result and convert to char array
            char[] curr = words[i].toCharArray(); // Get current word and convert to char array
            Arrays.sort(prev); // Sort previous word letters
            Arrays.sort(curr); // Sort current word letters
            
            if (!Arrays.equals(prev, curr)) { // If words are not anagrams
                result.add(words[i]); // Add current word to result
            }
        }
        
        return result; // Return the final list after removing anagrams
    }
}
