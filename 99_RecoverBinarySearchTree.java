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
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null; // Nodes to swap and previous node
        TreeNode curr = root; // Start from root

        while (curr != null) { // Traverse tree
            if (curr.left == null) { // No left child
                if (prev != null && prev.val > curr.val) { // Check violation
                    if (first == null) first = prev; // First swapped node
                    second = curr; // Second swapped node
                }
                prev = curr; // Update previous
                curr = curr.right; // Move right
            } else {
                TreeNode pre = curr.left; // Find predecessor
                while (pre.right != null && pre.right != curr) { // Go to rightmost
                    pre = pre.right; // Move right
                }

                if (pre.right == null) { // Thread not created
                    pre.right = curr; // Create thread
                    curr = curr.left; // Move left
                } else { // Thread exists
                    pre.right = null; // Remove thread
                    if (prev != null && prev.val > curr.val) { // Check violation
                        if (first == null) first = prev; // First swapped node
                        second = curr; // Second swapped node
                    }
                    prev = curr; // Update previous
                    curr = curr.right; // Move right
                }
            }
        }

        int temp = first.val; // Swap the two nodes
        first.val = second.val;
        second.val = temp;
    }
}
