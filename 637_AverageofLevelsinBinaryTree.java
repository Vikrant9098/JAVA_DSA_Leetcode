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
    public List<Double> averageOfLevels(TreeNode root) {
        // List to store the average of each level
        List<Double> result = new ArrayList<>();
        // If tree is empty, return empty list
        if (root == null) return result;

        // Queue for BFS (level-order traversal)
        Queue<TreeNode> queue = new LinkedList<>();
        // Start BFS with root node
        queue.offer(root);

        // Loop until queue is empty (all levels processed)
        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int size = queue.size();
            // Sum of node values at this level
            long sum = 0;  // use long to avoid overflow for big numbers

            // Process all nodes of this level
            for (int i = 0; i < size; i++) {
                // Take one node out of the queue
                TreeNode node = queue.poll();
                // Add its value to the sum
                sum += node.val;

                // Add left child to the queue if it exists
                if (node.left != null) queue.offer(node.left);
                // Add right child to the queue if it exists
                if (node.right != null) queue.offer(node.right);
            }

            // Compute average for this level and add to result list
            result.add(sum * 1.0 / size);
        }

        // Return list of averages for each level
        return result;
    }
}
