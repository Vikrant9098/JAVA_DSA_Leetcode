/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // Start from the root node
        Node head = root;
        
        // Loop until no more levels
        while (head != null) {
            // Dummy node for building next level links
            Node dummy = new Node(0);
            // Tail pointer to connect children
            Node tail = dummy;
            
            // Traverse current level using next pointers
            while (head != null) {
                // If left child exists, connect it
                if (head.left != null) {
                    tail.next = head.left;
                    tail = tail.next;
                }
                // If right child exists, connect it
                if (head.right != null) {
                    tail.next = head.right;
                    tail = tail.next;
                }
                // Move to next node in current level
                head = head.next;
            }
            // Move down to next level (dummy.next points to first child)
            head = dummy.next;
        }
        // Return the updated root
        return root;
    }
}
