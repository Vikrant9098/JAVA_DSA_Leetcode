class Trie {

    // Inner class representing each node of the Trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Array to store references to child nodes for each character a-z
        boolean isEndOfWord = false; // Flag to indicate the end of a complete word
    }

    private TrieNode root; // Root node of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        root = new TrieNode(); // Create the root node
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root; // Start from the root node

        // Traverse each character in the word
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Convert character to index (0 for 'a', 1 for 'b', ..., 25 for 'z')

            // If the corresponding child node does not exist, create it
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create a new node for the character
            }

            node = node.children[index]; // Move to the child node
        }

        node.isEndOfWord = true; // Mark the last node as the end of a word
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root; // Start from the root

        // Traverse each character in the word
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Convert character to index

            // If the child node for this character doesn't exist, word is not in Trie
            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index]; // Move to the next node
        }

        // Return true only if the last node is marked as end of a word
        return node.isEndOfWord;
    }

    // Method to check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root; // Start from the root

        // Traverse each character in the prefix
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a'; // Convert character to index

            // If the corresponding child node doesn't exist, prefix not found
            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index]; // Move to the next node
        }

        return true; // All characters in prefix found in Trie
    }
}
