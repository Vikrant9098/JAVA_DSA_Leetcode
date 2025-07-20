import java.util.*; // Importing List and ArrayList classes

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;                 // Value of the node
    TreeNode left;           // Left child node
    TreeNode right;          // Right child node

    TreeNode() {}            // Default constructor

    TreeNode(int val) {      // Constructor to initialize node with a value
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {  // Constructor with value, left and right nodes
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Create two lists to hold the leaf values of both trees
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Populate the leaf values for root1 into leaves1
        getLeaves(root1, leaves1);

        // Populate the leaf values for root2 into leaves2
        getLeaves(root2, leaves2);

        // Compare both leaf sequences; return true if they are equal, else false
        return leaves1.equals(leaves2);
    }

    /**
     * Recursive helper method to collect the leaf node values of a tree
     * @param node - the current node in the tree
     * @param leaves - the list to store the leaf node values
     */
    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return; // Base case: if node is null, do nothing
        }

        // Check if current node is a leaf (no left or right children)
        if (node.left == null && node.right == null) {
            leaves.add(node.val); // Add the value of the leaf node to the list
        }

        // Recur on the left subtree
        getLeaves(node.left, leaves);

        // Recur on the right subtree
        getLeaves(node.right, leaves);
    }
}
