class Solution {

    // Helper class to store height and node
    class Result {
        int height;      // Height of the subtree
        TreeNode node;   // Node that contains all deepest nodes

        // Constructor to initialize values
        Result(int h, TreeNode n) {
            height = h;
            node = n;
        }
    }

    // DFS function to process each node
    private Result dfs(TreeNode node) {

        // If node is null, height is 0 and no node
        if (node == null) 
            return new Result(0, null);
        
        // Recursively process left subtree
        Result left = dfs(node.left);

        // Recursively process right subtree
        Result right = dfs(node.right);
        
        // If left subtree is deeper
        if (left.height > right.height) {
            // Increase height and carry left result node
            return new Result(left.height + 1, left.node);

        // If right subtree is deeper
        } else if (right.height > left.height) {
            // Increase height and carry right result node
            return new Result(right.height + 1, right.node);

        // If both subtrees have same height
        } else {
            // Current node is the common ancestor
            return new Result(left.height + 1, node);
        }
    }

    // Main function to find subtree with all deepest nodes
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Run DFS and return the stored node
        return dfs(root).node;
    }
}
