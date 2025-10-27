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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node before the head
        ListNode dummy = new ListNode(0);
        
        // Point dummy node to the head of the list
        dummy.next = head;

        // Use current node to move through the list
        ListNode current = dummy;

        // Traverse the list until the end
        while (current.next != null) {
            // If next node value matches val, skip it
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                // Else move to next node
                current = current.next;
            }
        }

        // Return new head (after dummy)
        return dummy.next;
    }
}
