/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;                       // value of the node
 *     TreeNode left;                 // pointer to the left child
 *     TreeNode right;                // pointer to the right child
 *     TreeNode() {}                  // default constructor
 *     TreeNode(int val) {            // constructor with value
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) { // constructor with children
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null; // if node is null, return null (value not found)
        }

        if (root.val == val) {
            return root; // if current node's value matches target, return this node
        }

        if (val < root.val) {
            return searchBST(root.left, val); // search in left subtree if val is smaller
        } else {
            return searchBST(root.right, val); // search in right subtree if val is greater
        }
    }
}
