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
    public ListNode insertionSortList(ListNode head) {
        // Dummy node to simplify insertions at head
        ListNode dummy = new ListNode(0);
        
        // Start from the head of original list
        ListNode curr = head;
        
        // Traverse all nodes in the original list
        while (curr != null) {
            // Start from dummy for finding insertion point
            ListNode prev = dummy;
            
            // Find where to insert current node in sorted list
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            // Store next node before changing links
            ListNode nextTemp = curr.next;
            
            // Insert current node in sorted position
            curr.next = prev.next;
            prev.next = curr;
            
            // Move to next node in original list
            curr = nextTemp;
        }
        
        // Return sorted list starting after dummy
        return dummy.next;
    }
}
