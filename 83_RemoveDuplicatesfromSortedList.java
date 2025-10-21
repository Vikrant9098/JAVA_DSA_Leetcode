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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // If list is empty or has only one node, return it as it is
        if (head == null || head.next == null) return head;
        
        // Start from the first node
        ListNode current = head;
        
        // Traverse the list until the last node
        while (current != null && current.next != null) {
            // If current node and next node have same value
            if (current.val == current.next.val) {
                // Skip the next node (remove duplicate)
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }
        
        // Return the head of the updated list
        return head;
    }
}
