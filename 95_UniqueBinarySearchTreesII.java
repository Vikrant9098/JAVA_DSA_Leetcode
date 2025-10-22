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
    public List<TreeNode> generateTrees(int n) { // Main function
        if (n == 0) return new ArrayList<>(); // If no nodes, return empty list
        return build(1, n); // Build BSTs using values from 1 to n
    }

    private List<TreeNode> build(int start, int end) { // Helper function to build trees
        List<TreeNode> res = new ArrayList<>(); // List to store all possible trees
        if (start > end) { // Base case: no numbers to form tree
            res.add(null); // Add null as possible subtree
            return res;
        }

        for (int i = start; i <= end; i++) { // Choose each number as root
            List<TreeNode> left = build(start, i - 1); // All possible left subtrees
            List<TreeNode> right = build(i + 1, end); // All possible right subtrees

            for (TreeNode l : left) { // Combine each left subtree
                for (TreeNode r : right) { // With each right subtree
                    TreeNode root = new TreeNode(i); // Create root node
                    root.left = l; // Attach left subtree
                    root.right = r; // Attach right subtree
                    res.add(root); // Add complete tree to result
                }
            }
        }

        return res; // Return all trees for this range
    }
}
