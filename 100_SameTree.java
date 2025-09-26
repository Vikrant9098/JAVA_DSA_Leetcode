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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other is not, they are different
        if (p == null || q == null) {
            return false;
        }

        // If values are different, trees are not the same
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left subtree and right subtree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
