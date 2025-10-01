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
    // variable to track previous node value during inorder traversal
    private Integer prev = null;
    
    // variable to store minimum difference found
    private int minDiff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        // call inorder traversal
        inorder(root);
        // return the minimum difference found
        return minDiff;
    }
    
    private void inorder(TreeNode node) {
        // base case: if node is null, return
        if (node == null) return;
        
        // go left first (inorder traversal)
        inorder(node.left);
        
        // if we have a previous value, calculate difference
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        
        // update previous to current node's value
        prev = node.val;
        
        // go right next
        inorder(node.right);
    }
}
