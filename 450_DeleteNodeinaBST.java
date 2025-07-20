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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: if root is null, return null
        if (root == null) return null;

        // If the key to be deleted is smaller than the root's key,
        // then it lies in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to be deleted is greater than the root's key,
        // then it lies in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // Key is same as root's key, this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;  // If left is null, return right subtree
            else if (root.right == null) return root.left;  // If right is null, return left subtree

            // Node with two children:
            // Get the inorder successor (smallest in the right subtree)
            TreeNode minNode = findMin(root.right);

            // Copy the inorder successor's value to this node
            root.val = minNode.val;

            // Delete the inorder successor
            root.right = deleteNode(root.right, minNode.val);
        }

        // Return the (possibly updated) root
        return root;
    }

    // Helper function to find the node with the minimum value
    private TreeNode findMin(TreeNode node) {
        // Loop to find the leftmost leaf
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
