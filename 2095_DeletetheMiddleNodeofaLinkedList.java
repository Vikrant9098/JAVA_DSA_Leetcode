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
    public ListNode deleteMiddle(ListNode head) {
        // If the list has only one node, return null since that node is the middle
        if (head == null || head.next == null) return null;

        // Initialize slow and fast pointers to find the middle node
        ListNode slow = head;       // Will eventually point to the node before the middle
        ListNode fast = head.next.next; // Fast pointer moves twice as fast

        // Traverse the list: move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {
            slow = slow.next;       // slow moves one step
            fast = fast.next.next;  // fast moves two steps
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;

        // Return the head of the modified list
        return head;
    }
}
