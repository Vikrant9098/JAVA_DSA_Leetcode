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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if head is null or left == right, no change needed
        if (head == null || left == right) return head;
        
        // Dummy node to simplify handling of head reversal
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move prev to the node before the 'left' position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // start will point to the first node to be reversed
        ListNode start = prev.next;
        // then is the node that will be moved to the front of the reversed part
        ListNode then = start.next;
        
        // Reverse the sublist from left to right
        for (int i = 0; i < right - left; i++) {
            start.next = then.next; // detach then
            then.next = prev.next;  // move then to the front
            prev.next = then;       // connect prev to then
            then = start.next;      // move then to the next node to reverse
        }
        
        // Return the new head (dummy.next)
        return dummy.next;
    }
}
