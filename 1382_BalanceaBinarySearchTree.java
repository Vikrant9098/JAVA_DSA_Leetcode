// Solution class
class Solution {

    // Main method to balance a Binary Search Tree
    public TreeNode balanceBST(TreeNode root) {

        // List to store BST elements in sorted order
        List<Integer> sortedElements = new ArrayList<>();

        // Perform inorder traversal to collect elements in sorted order
        inOrderTraversal(root, sortedElements);

        // Build and return a balanced BST from the sorted list
        return buildBalancedBST(sortedElements, 0, sortedElements.size() - 1);
    }

    // Helper method to perform inorder traversal
    private void inOrderTraversal(TreeNode node, List<Integer> sortedElements) {

        // If current node is null, stop recursion
        if (node == null) {
            return;
        }

        // Recursively visit the left subtree
        inOrderTraversal(node.left, sortedElements);

        // Add current node value to the list
        sortedElements.add(node.val);

        // Recursively visit the right subtree
        inOrderTraversal(node.right, sortedElements);
    }

    // Helper method to build a balanced BST from sorted elements
    private TreeNode buildBalancedBST(List<Integer> elements, int start, int end) {

        // If start index is greater than end index, no node to create
        if (start > end) {
            return null;
        }

        // Find the middle index of the current range
        int mid = start + (end - start) / 2;

        // Create a new tree node using the middle element
        TreeNode node = new TreeNode(elements.get(mid));

        // Recursively build the left subtree using left half of list
        node.left = buildBalancedBST(elements, start, mid - 1);

        // Recursively build the right subtree using right half of list
        node.right = buildBalancedBST(elements, mid + 1, end);

        // Return the created node
        return node;
    }
}

// Definition of TreeNode class
class TreeNode {

    // Value stored in the node
    int val;

    // Reference to left child
    TreeNode left;

    // Reference to right child
    TreeNode right;

    // Default constructor
    TreeNode() {}

    // Constructor with value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor with value, left child, and right child
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
