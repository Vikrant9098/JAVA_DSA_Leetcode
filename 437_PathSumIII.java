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
    // This is the main method to be called, it initializes the path count
    public int pathSum(TreeNode root, int targetSum) {
        // Call the helper method to recursively find all paths that sum to targetSum
        return dfs(root, targetSum);
    }

    // Helper method to go through each node and try to start a path from there
    private int dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return 0; // Base case: if node is null, there are no paths
        }

        // Count paths starting from this node + paths from left + paths from right
        return countFromNode(node, targetSum) 
                + dfs(node.left, targetSum) 
                + dfs(node.right, targetSum);
    }

    // Helper method to count paths starting from a specific node
    private int countFromNode(TreeNode node, long targetSum) {
        if (node == null) {
            return 0; // No path if we reach null
        }

        int count = 0;

        // If current node's value equals the targetSum, this is a valid path
        if (node.val == targetSum) {
            count++;
        }

        // Recursively count valid paths in left and right subtrees,
        // decreasing the targetSum by current node's value
        count += countFromNode(node.left, targetSum - node.val);
        count += countFromNode(node.right, targetSum - node.val);

        return count; // Return total paths found from this node
    }
}
