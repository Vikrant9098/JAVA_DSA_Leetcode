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
    // Index pointer for preorder array
    private int preorderIndex = 0;

    // Map to store value -> index for inorder array for quick lookup
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a map for inorder traversal (value -> index)
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start recursive tree building
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: if no elements to construct the tree
        if (left > right) {
            return null;
        }

        // Select the current element as the root
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees
        // Elements left of rootValue in inorder[] are in the left subtree
        // Elements right of rootValue in inorder[] are in the right subtree
        root.left = arrayToTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootValue) + 1, right);

        return root;
    }
}
