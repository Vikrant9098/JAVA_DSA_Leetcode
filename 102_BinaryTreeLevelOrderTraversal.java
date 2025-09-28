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

import javax.swing.tree.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // list to store levels
        if (root == null) return result;               // if tree empty, return empty list

        Queue<TreeNode> queue = new LinkedList<>();    // queue for BFS
        queue.offer(root);                             // start BFS with root

        // process each level
        while (!queue.isEmpty()) {
            int size = queue.size();                   // number of nodes in current level
            List<Integer> level = new ArrayList<>();   // list to store current level values

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();          // remove node from queue
                level.add(node.val);                   // add node value to level list

                if (node.left != null) queue.offer(node.left);   // add left child to queue
                if (node.right != null) queue.offer(node.right); // add right child to queue
            }

            result.add(level);                          // add current level to result
        }

        return result;                                  // return list of all levels
    }
}
