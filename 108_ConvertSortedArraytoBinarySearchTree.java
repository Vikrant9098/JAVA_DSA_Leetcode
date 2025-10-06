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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1); // Start recursive BST construction
    }

    // Helper function to build BST from nums[start...end]
    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null; // Base case: no elements to process

        int mid = start + (end - start) / 2; // Choose middle element as root
        TreeNode root = new TreeNode(nums[mid]); // Create root node

        // Recursively build left subtree from left half
        root.left = buildBST(nums, start, mid - 1);

        // Recursively build right subtree from right half
        root.right = buildBST(nums, mid + 1, end);

        return root; // Return the constructed subtree
    }
}
