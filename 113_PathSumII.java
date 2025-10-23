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
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>(); // to store all valid paths
        List<Integer> current = new ArrayList<>();      // to store current path
        dfs(root, targetSum, current, result);         // start DFS from root
        return result;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return; // base case: reached null node

        path.add(node.val); // add current node to path
        target -= node.val; // decrease target by current node value

        // If leaf node and target is 0, path is valid
        if (node.left == null && node.right == null && target == 0) {
            result.add(new ArrayList<>(path)); // add a copy of path to result
        } else {
            dfs(node.left, target, path, result);  // explore left subtree
            dfs(node.right, target, path, result); // explore right subtree
        }

        path.remove(path.size() - 1); // backtrack: remove current node before returning
    }
}
