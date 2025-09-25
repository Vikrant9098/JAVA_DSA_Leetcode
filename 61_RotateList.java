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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;  
        // If list is empty, has 1 node, or no rotation needed, return as is

        ListNode tail = head;
        int length = 1;  
        // Start with length 1 (since head is not null)

        while (tail.next != null) {
            tail = tail.next;  
            // Move to end of list
            length++;  
            // Count total nodes
        }

        tail.next = head;  
        // Make the list circular

        k = k % length;  
        // Reduce k (rotation by length is same list)
        int stepsToNewHead = length - k;  
        // Find how many steps to reach new head

        ListNode newTail = tail;  
        // Start from tail
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;  
            // Move forward to find new tail
        }

        ListNode newHead = newTail.next;  
        // Next node becomes new head
        newTail.next = null;  
        // Break the circle to form proper list

        return newHead;  
        // Return rotated list head
    }
}
