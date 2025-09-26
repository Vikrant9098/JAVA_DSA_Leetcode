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
    public TreeNode invertTree(TreeNode root) {
        // If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // Swap left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left subtree
        invertTree(root.left);

        // Recursively invert right subtree
        invertTree(root.right);

        // Return the root after inversion
        return root;
    }
}
