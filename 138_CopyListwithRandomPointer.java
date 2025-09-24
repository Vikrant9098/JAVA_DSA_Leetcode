/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null; // handle empty list
        
        // Map to store original node -> copied node
        HashMap<Node, Node> map = new HashMap<>();
        
        // First pass: create all nodes and store in map
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        // Second pass: set next and random pointers
        current = head;
        while (current != null) {
            Node copy = map.get(current);              // get the copied node
            copy.next = map.get(current.next);        // set next pointer
            copy.random = map.get(current.random);    // set random pointer
            current = current.next;
        }
        
        // Return the head of the copied list
        return map.get(head);
    }
}
