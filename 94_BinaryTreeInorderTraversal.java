import java.util.*;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // store inorder traversal
        Stack<TreeNode> stack = new Stack<>(); // stack to help traverse iteratively
        TreeNode current = root; // start from root

        while (current != null || !stack.isEmpty()) {
            // go as left as possible
            while (current != null) {
                stack.push(current); // push current node to stack
                current = current.left; // move to left child
            }

            current = stack.pop(); // pop node from stack
            result.add(current.val); // visit node

            current = current.right; // move to right child
        }

        return result; // return inorder traversal
    }
}
