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
    private int maxDiameter = 0; // store maximum diameter found

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root); // start depth-first search from root
        return maxDiameter; // return the diameter
    }

    // helper function to calculate depth of tree
    private int depth(TreeNode node) {
        if (node == null) return 0; // empty node has depth 0

        int left = depth(node.left); // depth of left subtree
        int right = depth(node.right); // depth of right subtree

        maxDiameter = Math.max(maxDiameter, left + right); // update diameter if larger

        return 1 + Math.max(left, right); // return depth of current node
    }
}
