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
    public int maxDepth(TreeNode root) {
        // Base case: if the tree is empty, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of left subtree
        int leftDepth = maxDepth(root.left);

        // Recursively find the depth of right subtree
        int rightDepth = maxDepth(root.right);

        // The depth at current node is 1 + max of left and right subtree depths
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
