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
    public boolean isValidBST(TreeNode root) {
        // call helper function with full integer range
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long low, long high) {
        // if node is null, it's valid
        if (node == null) return true;
        
        // node value must be in range (low < val < high)
        if (node.val <= low || node.val >= high) return false;
        
        // check left subtree with updated high limit
        // check right subtree with updated low limit
        return helper(node.left, low, node.val) && 
               helper(node.right, node.val, high);
    }
}
