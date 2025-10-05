class WordDictionary {

    // Inner class representing each Trie node
    private class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Each node can have 26 children (a-z)
        boolean isEndOfWord = false; // Marks if a word ends here
    }

    private TrieNode root; // Root node of the Trie

    // Constructor: create an empty root node
    public WordDictionary() {
        root = new TrieNode();
    }

    // Method to add a word into the Trie
    public void addWord(String word) {
        TrieNode node = root; // Start from the root
        for (char c : word.toCharArray()) { // Loop through each character
            int index = c - 'a'; // Find index (0-25) for each character
            if (node.children[index] == null) { // If no node exists for this char
                node.children[index] = new TrieNode(); // Create a new node
            }
            node = node.children[index]; // Move to the next node
        }
        node.isEndOfWord = true; // Mark the last node as end of a word
    }

    // Method to search a word, supports '.' as a wildcard
    public boolean search(String word) {
        return searchInNode(word, root); // Start search from root node
    }

    // Helper function to perform recursive search
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) { // Loop through each character
            char c = word.charAt(i); // Current character

            // If character is '.', it can match any letter
            if (c == '.') {
                for (TrieNode child : node.children) { // Try all possible children
                    // If child exists and remaining word matches recursively
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true; // Found a valid match
                    }
                }
                return false; // No match found for this wildcard
            } 
            // If it's a normal letter
            else {
                int index = c - 'a'; // Get the index for the letter
                if (node.children[index] == null) { // If no path exists
                    return false; // Word not found
                }
                node = node.children[index]; // Move to next node
            }
        }
        return node.isEndOfWord; // Return true if we ended on a complete word
    }
}

/**
 * Usage Example:
 * WordDictionary obj = new WordDictionary(); // Create a WordDictionary
 * obj.addWord("bad"); // Add a word
 * boolean found = obj.search("b.."); // Search with wildcard
 */
