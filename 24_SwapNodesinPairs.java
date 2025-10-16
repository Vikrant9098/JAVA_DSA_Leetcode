public class 24_SwapNodesinPairs {
    
}
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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node before head (helps in swapping first pair)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // prev points to node before the pair being swapped
        ListNode prev = dummy;
        
        // Loop until we have at least two nodes to swap
        while (head != null && head.next != null) {
            // Identify the two nodes to swap
            ListNode first = head;
            ListNode second = head.next;
            
            // Perform the swap
            prev.next = second;       // previous node points to second
            first.next = second.next; // first points to node after second
            second.next = first;      // second now points to first
            
            // Move pointers ahead for next swap
            prev = first;
            head = first.next;
        }
        
        // Return the new head of the swapped list
        return dummy.next;
    }
}
