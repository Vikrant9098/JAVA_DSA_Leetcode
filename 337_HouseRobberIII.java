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
    public int rob(TreeNode root) {
        // call helper and get result array [notRob, rob]
        int[] res = dfs(root);
        // return max of robbing or not robbing root
        return Math.max(res[0], res[1]);
    }

    // helper function returns int[2]: [notRob, rob]
    private int[] dfs(TreeNode node) {
        // base case: if node is null
        if (node == null) return new int[2];

        // get result from left and right children
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // if we rob this node, we can't rob its children
        int rob = node.val + left[0] + right[0];

        // if we don't rob this node, we can choose max from children
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // return both results
        return new int[]{notRob, rob};
    }
}
