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
    private int maxSum = Integer.MIN_VALUE; // To keep track of maximum path sum
    
    public int maxPathSum(TreeNode root) {
        dfs(root); // Start DFS
        return maxSum;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0; // Base case: null node contributes 0
        
        // Compute max path sum from left and right subtrees (ignore negative paths)
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        
        // Update global maximum if current path through node is higher
        maxSum = Math.max(maxSum, node.val + left + right);
        
        // Return max path sum extending to parent (only one side can be taken)
        return node.val + Math.max(left, right);
    }
}
