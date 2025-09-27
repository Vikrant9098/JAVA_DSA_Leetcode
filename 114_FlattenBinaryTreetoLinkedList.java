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
    public void flatten(TreeNode root) {
        // Start from the root node
        TreeNode curr = root;
        
        // Loop until all nodes are processed
        while (curr != null) {
            // If there is a left subtree
            if (curr.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                
                // Connect right subtree to that rightmost node
                prev.right = curr.right;
                
                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null; // Set left to null
            }
            // Move to the next node (always on right now)
            curr = curr.right;
        }
    }
}
