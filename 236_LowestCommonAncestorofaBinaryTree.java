/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: If the current node is null, return null (end of path)
        if (root == null) return null;

        // If the current node is either p or q, then return the current node
        // because p or q could be one of the ancestors
        if (root == p || root == q) return root;

        // Recursively search in the left subtree
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);

        // Recursively search in the right subtree
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both left and right recursive calls returned non-null,
        // it means p is in one subtree and q is in the other subtree.
        // Hence, current root is the lowest common ancestor
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one of the sides is non-null, return that non-null node.
        // That means both p and q are located in that subtree
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}=