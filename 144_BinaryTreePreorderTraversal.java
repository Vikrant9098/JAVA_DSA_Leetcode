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
    public List<Integer> preorderTraversal(TreeNode root) {
        // Create a list to store traversal result
        List<Integer> result = new ArrayList<>();
        
        // If root is null, return empty list
        if (root == null)
            return result;
        
        // Create a stack to help with iteration
        Stack<TreeNode> stack = new Stack<>();
        
        // Push the root node onto the stack
        stack.push(root);
        
        // Repeat until stack becomes empty
        while (!stack.isEmpty()) {
            // Pop the top node from the stack
            TreeNode node = stack.pop();
            
            // Add the node's value to the result list
            result.add(node.val);
            
            // If the right child exists, push it first
            if (node.right != null)
                stack.push(node.right);
            
            // If the left child exists, push it next
            if (node.left != null)
                stack.push(node.left);
        }
        
        // Return the final preorder traversal list
        return result;
    }
}
