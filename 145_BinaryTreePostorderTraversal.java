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
    public List<Integer> postorderTraversal(TreeNode root) {
        // Create a list to store postorder traversal result
        List<Integer> result = new ArrayList<>();
        
        // If tree is empty, return empty list
        if (root == null)
            return result;
        
        // Use two stacks for iterative postorder traversal
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        // Push the root node onto the first stack
        stack1.push(root);
        
        // Continue until first stack becomes empty
        while (!stack1.isEmpty()) {
            // Pop a node from first stack
            TreeNode node = stack1.pop();
            
            // Push it onto second stack
            stack2.push(node);
            
            // Push left child to first stack if it exists
            if (node.left != null)
                stack1.push(node.left);
            
            // Push right child to first stack if it exists
            if (node.right != null)
                stack1.push(node.right);
        }
        
        // Pop all nodes from second stack and add their values to result
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        
        // Return final postorder traversal list
        return result;
    }
}
