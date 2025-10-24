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
        // If tree is empty, return null
        if (root == null) return null;

        // Start from the leftmost node of the current level
        Node leftmost = root;

        // Loop until we reach the last level
        while (leftmost.left != null) {
            // Move across the current level using 'next' pointers
            Node head = leftmost;

            while (head != null) {
                // Connect left child to right child
                head.left.next = head.right;

                // Connect right child to next node’s left child (if exists)
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Move to next node in the same level
                head = head.next;
            }

            // Move to the next level (leftmost of next level)
            leftmost = leftmost.left;
        }

        // Return the root of the updated tree
        return root;
    }
}
