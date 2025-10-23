/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // If the list is empty, no tree can be formed
        if (head == null) return null;
        
        // If the list has only one node, that becomes a leaf node
        if (head.next == null) return new TreeNode(head.val);
        
        // prev will track the node before the middle
        ListNode prev = null;
        // slow will move one step at a time (to find the middle)
        ListNode slow = head;
        // fast will move two steps at a time
        ListNode fast = head;
        
        // Loop until fast reaches the end
        while (fast != null && fast.next != null) {
            prev = slow;         // move prev to current slow
            slow = slow.next;    // move slow one step
            fast = fast.next.next; // move fast two steps
        }
        
        // Disconnect left half from middle (cut the list)
        if (prev != null) prev.next = null;
        
        // slow is now the middle node — create root from it
        TreeNode root = new TreeNode(slow.val);
        
        // Recursively build the left subtree from the left half
        root.left = sortedListToBST(head);
        
        // Recursively build the right subtree from the right half
        root.right = sortedListToBST(slow.next);
        
        // Return the root node
        return root;
    }
}
