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
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or only one node, it's the new head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode reversedHead = reverseList(head.next);

        // Reverse current node's pointer
        head.next.next = head;  // Make the next node point to current
        head.next = null;       // Break the current link

        return reversedHead;    // Return new head node
    }
}
