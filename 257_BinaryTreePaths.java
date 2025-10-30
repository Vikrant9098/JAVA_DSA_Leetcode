/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>(); // List to store all paths
        if (root == null) return paths; // If tree is empty, return empty list
        buildPaths(root, "", paths); // Start DFS traversal from root
        return paths; // Return all collected paths
    }

    private void buildPaths(TreeNode node, String path, List<String> paths) {
        if (node != null) { // Check if node exists
            path += node.val; // Add current node’s value to path
            if (node.left == null && node.right == null) { 
                // If it's a leaf node, add path to list
                paths.add(path);
            } else { 
                // If not leaf, continue to explore children
                path += "->"; // Add arrow between nodes
                buildPaths(node.left, path, paths); // Recur for left child
                buildPaths(node.right, path, paths); // Recur for right child
            }
        }
    }
}
