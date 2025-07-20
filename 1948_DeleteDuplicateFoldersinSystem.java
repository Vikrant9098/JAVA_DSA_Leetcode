class Solution {
    
    // Node class to represent each folder in the file system
    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>(); // Map of subfolder names to their TrieNodes
        String key = ""; // Serialization key for subtree
        boolean isDuplicate = false; // Flag to mark if this node is part of a duplicate subtree
    }

    // Main function to delete duplicate folders
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode(); // Root node of the Trie

        // Step 1: Build Trie from input paths
        for (List<String> path : paths) {
            TrieNode current = root;
            for (String folder : path) {
                current = current.children.computeIfAbsent(folder, k -> new TrieNode()); // Add folder if not exists
            }
        }

        Map<String, List<TrieNode>> seen = new HashMap<>(); // To record serialized subtrees

        // Step 2: Serialize all subtrees and group by their serialization
        serialize(root, seen);

        // Step 3: Mark duplicate subtrees
        for (List<TrieNode> group : seen.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.isDuplicate = true; // Mark all nodes in this group as duplicate
                }
            }
        }

        List<List<String>> result = new ArrayList<>(); // To store the final remaining paths

        // Step 4: DFS to collect paths that are not marked as duplicate
        dfs(root, new ArrayList<>(), result);

        return result;
    }

    // Helper method to serialize each subtree
    private String serialize(TrieNode node, Map<String, List<TrieNode>> seen) {
        if (node.children.isEmpty()) return ""; // No children means leaf, return empty string

        StringBuilder sb = new StringBuilder(); // To build serialization string

        // Sort children keys to make serialization deterministic
        List<String> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys);

        // Build the serialization string from all children
        for (String key : keys) {
            sb.append("(").append(key).append(serialize(node.children.get(key), seen)).append(")");
        }

        node.key = sb.toString(); // Store serialization in node

        // Add this node to seen map using its serialization
        seen.computeIfAbsent(node.key, k -> new ArrayList<>()).add(node);

        return node.key;
    }

    // DFS to collect valid (non-duplicate) paths
    private void dfs(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();

            if (child.isDuplicate) continue; // Skip if node is duplicate

            path.add(folder); // Add folder to current path
            result.add(new ArrayList<>(path)); // Add a copy of current path to result

            dfs(child, path, result); // Recurse for next level

            path.remove(path.size() - 1); // Backtrack
        }
    }
}
