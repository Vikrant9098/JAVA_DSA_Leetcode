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
    public void reorderList(ListNode head) {
        // If the list has 0 or 1 element, no reordering is needed
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list
        ListNode slow = head;  // Slow pointer moves one step at a time
        ListNode fast = head;  // Fast pointer moves two steps at a time
        while (fast != null && fast.next != null) {  // Continue until fast reaches the end
            slow = slow.next;      // Move slow one step
            fast = fast.next.next; // Move fast two steps
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;     // Will store the previous node (initially null)
        ListNode curr = slow.next; // Start reversing from the node after middle
        slow.next = null;         // Break the list into two halves
        while (curr != null) {    // Traverse until all nodes in the second half are reversed
            ListNode nextTemp = curr.next; // Store next node temporarily
            curr.next = prev;              // Reverse the link direction
            prev = curr;                   // Move prev one step ahead
            curr = nextTemp;               // Move curr one step ahead
        }

        // Step 3: Merge the two halves alternately
        ListNode first = head;  // Pointer for the first half
        ListNode second = prev; // Pointer for the reversed second half
        while (second != null) {  // Continue until second half is exhausted
            ListNode temp1 = first.next; // Store next node of first half
            ListNode temp2 = second.next; // Store next node of second half

            first.next = second;  // Link first node to one from second half
            second.next = temp1;  // Link that node back to the next in first half

            first = temp1;  // Move first pointer forward
            second = temp2; // Move second pointer forward
        }
    }
}
