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
    public boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null) {
            return true;
        }
        // Check if left and right subtrees are mirror images
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they are mirrors
        if (t1 == null && t2 == null) {
            return true;
        }
        // If only one is null, not mirrors
        if (t1 == null || t2 == null) {
            return false;
        }
        // Check values and recursively check children in mirrored positions
        return (t1.val == t2.val) 
            && isMirror(t1.left, t2.right) 
            && isMirror(t1.right, t2.left);
    }
}
