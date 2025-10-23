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
    public boolean isBalanced(TreeNode root) {
        // Call helper function that returns -1 if not balanced
        return checkHeight(root) != -1;
    }

    // Helper function to compute height and check balance
    private int checkHeight(TreeNode node) {
        // Base case: if node is null, height = 0
        if (node == null) return 0;

        // Recursively check height of left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // left subtree not balanced

        // Recursively check height of right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // right subtree not balanced

        // If height difference is more than 1, not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
