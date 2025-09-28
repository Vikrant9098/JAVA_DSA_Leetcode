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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // list to store final result
        if (root == null) return result;               // if tree empty, return empty list

        Queue<TreeNode> queue = new LinkedList<>();    // queue for BFS
        queue.offer(root);                             // start BFS with root
        boolean leftToRight = true;                    // flag to track direction

        // process each level
        while (!queue.isEmpty()) {
            int size = queue.size();                   // number of nodes in current level
            List<Integer> level = new ArrayList<>();   // list to store current level values

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();          // remove node from queue

                // add value in order depending on direction
                if (leftToRight) {
                    level.add(node.val);              // left to right, add at end
                } else {
                    level.add(0, node.val);           // right to left, add at start
                }

                // add children to queue for next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);                          // add current level to result
            leftToRight = !leftToRight;                 // flip direction for next level
        }

        return result;                                  // return zigzag level order list
    }
}
