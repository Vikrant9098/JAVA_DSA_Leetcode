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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // If left and right subtree heights are equal, left subtree is perfect
        if (leftHeight == rightHeight) {
            // 2^leftHeight nodes in left subtree + root(1) + recurse on right
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            // Otherwise, right subtree is perfect
            // 2^rightHeight nodes in right subtree + root(1) + recurse on left
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    // Helper function to compute the height of the tree
    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
