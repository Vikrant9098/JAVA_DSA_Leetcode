import java.util.*;

class Solution {

    // Trie Node class definition
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>(); // Children nodes
        boolean isEndOfWord = false; // True if node is end of a word
    }

    // Build a Trie from the words list
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode(); // Root node
        for (String word : words) { // Loop through each word
            TrieNode node = root; // Start from root
            for (char c : word.toCharArray()) { // Loop through characters
                node.children.putIfAbsent(c, new TrieNode()); // Add child if not exists
                node = node.children.get(c); // Move to child
            }
            node.isEndOfWord = true; // Mark last char as end of word
        }
        return root; // Return the root of Trie
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>(); // List to store found words
        if (board == null || board.length == 0 || words == null || words.length == 0) return result; // Edge cases

        int m = board.length, n = board[0].length; // Board dimensions
        TrieNode root = buildTrie(words); // Build Trie from words

        boolean[][] visited = new boolean[m][n]; // Visited matrix to track used cells

        // Start DFS from every cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, "", visited, result); // Call DFS
            }
        }

        return result; // Return all found words
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, String path, boolean[][] visited, List<String> result) {
        int m = board.length, n = board[0].length; // Board dimensions

        // Check boundaries and visited status
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;

        char c = board[i][j]; // Current cell character
        if (!node.children.containsKey(c)) return; // If char not in Trie, stop

        node = node.children.get(c); // Move to child node in Trie
        path += c; // Append char to current path

        if (node.isEndOfWord) { // If current path is a word
            if (!result.contains(path)) { // Avoid duplicates
                result.add(path); // Add word to result
            }
        }

        visited[i][j] = true; // Mark cell as visited

        // Explore 4 directions: down, up, right, left
        dfs(board, i + 1, j, node, path, visited, result);
        dfs(board, i - 1, j, node, path, visited, result);
        dfs(board, i, j + 1, node, path, visited, result);
        dfs(board, i, j - 1, node, path, visited, result);

        visited[i][j] = false; // Backtrack and unmark cell
    }
}
