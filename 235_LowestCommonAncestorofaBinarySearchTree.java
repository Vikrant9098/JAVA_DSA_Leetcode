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
        // Start traversing from the root node
        while (root != null) {
            // If both p and q are smaller than root, LCA must be in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than root, LCA must be in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // Otherwise, we found the split point — this node is the LCA
            else {
                return root;
            }
        }
        return null; // In case tree is empty
    }
}
