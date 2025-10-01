import javax.swing.tree.TreeNode;

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
    // variable to keep track of the count of visited nodes
    private int count = 0;
    // variable to store the result
    private int result = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        // perform inorder traversal
        inorder(root, k);
        // return the result
        return result;
    }
    
    private void inorder(TreeNode node, int k) {
        // base case: if node is null, return
        if (node == null) return;
        
        // go left first (inorder)
        inorder(node.left, k);
        
        // visit current node
        count++;  // increase visited nodes count
        if (count == k) {  // if this is the kth node
            result = node.val; // store the answer
            return; // stop traversal
        }
        
        // go right
        inorder(node.right, k);
    }
}
