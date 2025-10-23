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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); // stores levels in bottom-up order
        if (root == null) return result; // if tree is empty

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // start BFS from root

        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // remove node from queue
                level.add(node.val); // add node value to current level list

                if (node.left != null) queue.offer(node.left); // enqueue left child
                if (node.right != null) queue.offer(node.right); // enqueue right child
            }

            // Add current level at the beginning (to get bottom-up order)
            result.add(0, level);
        }

        return result;
    }
}
