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
    public ListNode oddEvenList(ListNode head) {
        // Base condition: if the list is empty or has only one node, return as it is
        if (head == null || head.next == null) return head;

        // Initialize pointers
        ListNode odd = head;             // This pointer will track the last node in the odd-indexed list
        ListNode even = head.next;       // This pointer will track the last node in the even-indexed list
        ListNode evenHead = even;        // Save the starting point of even list to reconnect later

        // Iterate through the list while even and even.next are not null
        while (even != null && even.next != null) {
            odd.next = even.next;        // Link current odd to the next odd node
            odd = odd.next;              // Move the odd pointer forward

            even.next = odd.next;        // Link current even to the next even node
            even = even.next;            // Move the even pointer forward
        }

        // After loop, connect the last odd node to the head of the even list
        odd.next = evenHead;

        // Return the head of the reordered list
        return head;
    }
}
