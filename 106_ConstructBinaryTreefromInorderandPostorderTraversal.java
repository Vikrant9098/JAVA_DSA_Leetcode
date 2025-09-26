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
    private int postIndex; // Index pointer for postorder array
    private Map<Integer, Integer> inorderMap = new HashMap<>(); // value -> index in inorder

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; // Start from last element of postorder

        // Build hashmap for inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Build the tree recursively
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        // Base case: no elements to construct tree
        if (left > right) {
            return null;
        }

        // Pick current root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Root splits inorder into left and right subtrees
        int index = inorderMap.get(rootVal);

        // Important: build right subtree first because postorder goes left-right-root
        root.right = helper(postorder, index + 1, right);
        root.left = helper(postorder, left, index - 1);

        return root;
    }
}
