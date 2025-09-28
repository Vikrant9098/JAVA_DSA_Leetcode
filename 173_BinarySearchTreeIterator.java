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

import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);  // Initialize stack with leftmost path
    }
    
    public int next() {
        // Pop the top node (smallest available value)
        TreeNode node = stack.pop();
        // If the node has a right child, push its leftmost path
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        // If stack is not empty, there is a next node
        return !stack.isEmpty();
    }
    
    // Helper function to push all left nodes into the stack
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
