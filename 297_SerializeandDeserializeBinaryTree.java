/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Codec {

    // Encodes a tree to a single string using preorder traversal
    public String serialize(TreeNode root) {
        if (root == null) return "null,";  // null marker for empty node
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");   // add current node value
        sb.append(serialize(root.left));   // serialize left subtree
        sb.append(serialize(root.right));  // serialize right subtree
        return sb.toString();
    }

    // Helper method to build the tree back from list
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();         // get the next value
        if (val.equals("null")) return null; // null means no node
        TreeNode node = new TreeNode(Integer.parseInt(val)); // create node
        node.left = buildTree(nodes);      // recursively build left child
        node.right = buildTree(nodes);     // recursively build right child
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(","); // split serialized string
        Queue<String> nodes = new LinkedList<>(Arrays.asList(values)); // use queue for order
        return buildTree(nodes);           // build and return the root node
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
