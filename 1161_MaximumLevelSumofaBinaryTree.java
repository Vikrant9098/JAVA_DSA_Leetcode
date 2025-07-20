/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val; // value of the node
 *     TreeNode left; // left child
 *     TreeNode right; // right child
 *     TreeNode() {} // default constructor
 *     TreeNode(int val) { this.val = val; } // constructor with value
 *     TreeNode(int val, TreeNode left, TreeNode right) { // constructor with children
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // queue for level-order traversal (BFS)
        queue.offer(root); // add root node to the queue

        int maxSum = Integer.MIN_VALUE; // track maximum level sum seen so far
        int maxLevel = 1; // track level with maximum sum
        int currentLevel = 1; // track current level number

        while (!queue.isEmpty()) { // loop until queue is empty
            int levelSize = queue.size(); // number of nodes in current level
            int levelSum = 0; // sum of node values at current level

            for (int i = 0; i < levelSize; i++) { // process all nodes at this level
                TreeNode node = queue.poll(); // remove node from queue
                levelSum += node.val; // add node's value to current level sum

                if (node.left != null) { // if left child exists
                    queue.offer(node.left); // add left child to queue
                }

                if (node.right != null) { // if right child exists
                    queue.offer(node.right); // add right child to queue
                }
            }

            if (levelSum > maxSum) { // if this level's sum is greater than previous max
                maxSum = levelSum; // update max sum
                maxLevel = currentLevel; // update level number
            }

            currentLevel++; // move to the next level
        }

        return maxLevel; // return the level with the maximum sum
    }
}
