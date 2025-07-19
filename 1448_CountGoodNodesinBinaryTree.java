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
    public int goodNodes(TreeNode root) {
        // Call the helper function with initial max value as root's value
        return countGoodNodes(root, root.val);
    }

    // Helper method to count good nodes using DFS traversal
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) return 0; // Base case: if node is null, return 0

        int count = 0;

        // If current node's value is greater than or equal to maxSoFar, it's a good node
        if (node.val >= maxSoFar) {
            count = 1; // Count this node
        }

        // Update maxSoFar for the path to children
        int newMax = Math.max(maxSoFar, node.val);

        // Recursively count good nodes in left and right subtrees
        count += countGoodNodes(node.left, newMax);
        count += countGoodNodes(node.right, newMax);

        return count; // Return total count of good nodes in this subtree
    }
}
