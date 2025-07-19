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
    // This variable will keep track of the maximum ZigZag path found
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        // Start DFS from root node in both directions: 0 = left, 1 = right
        dfs(root.left, 0, 1);  // direction 0 means we just went left
        dfs(root.right, 1, 1); // direction 1 means we just went right
        return maxZigZag;      // return the maximum ZigZag path found
    }

    // Helper method to perform DFS traversal
    // node - current node
    // direction - 0 for left, 1 for right
    // length - current length of ZigZag path
    private void dfs(TreeNode node, int direction, int length) {
        if (node == null) {
            return; // base case: if node is null, end recursion
        }

        // Update the maximum ZigZag length found so far
        maxZigZag = Math.max(maxZigZag, length);

        if (direction == 0) {
            // Last move was to the left, so now move right and increase length
            dfs(node.right, 1, length + 1);

            // Restart ZigZag by moving left again with length = 1
            dfs(node.left, 0, 1);
        } else {
            // Last move was to the right, so now move left and increase length
            dfs(node.left, 0, length + 1);

            // Restart ZigZag by moving right again with length = 1
            dfs(node.right, 1, 1);
        }
    }
}
