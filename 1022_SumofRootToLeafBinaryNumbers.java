import javax.swing.tree.TreeNode;

class Solution {
    
    // Main function that starts recursion with initial sum = 0
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0); // Call helper method
    }
    
    // Helper recursive function
    public int sumRootToLeaf(TreeNode root, int sum){
        
        // Base case: if node is null, no value to add
        if(root == null) return 0;
        
        // Update sum: shift left (multiply by 2) and add current node value
        // This builds the binary number from root to current node
        sum = (2 * sum) + root.val;
        
        // If it is a leaf node (no left and right child)
        // Return the binary number formed so far
        if(root.left == null && root.right == null) return sum;
        
        // Recursively calculate sum from left and right subtree
        // Add both results
        return sumRootToLeaf(root.left, sum) + 
               sumRootToLeaf(root.right, sum);
    }
}