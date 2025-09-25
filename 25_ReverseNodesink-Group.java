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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head; 
        // If list is empty or k=1, no need to reverse

        ListNode dummy = new ListNode(0);  
        // Dummy node to handle head changes easily
        dummy.next = head;  
        // Link dummy to head

        ListNode prevGroupEnd = dummy;  
        // Pointer to track end of previous group

        while (true) {
            ListNode kth = getKthNode(prevGroupEnd, k);  
            // Find kth node from prevGroupEnd
            if (kth == null) break;  
            // If less than k nodes remain, stop

            ListNode groupStart = prevGroupEnd.next;  
            // First node of current group
            ListNode nextGroupStart = kth.next;  
            // Node after kth (next group start)

            ListNode prev = nextGroupStart;  
            // prev initially points to next group's start
            ListNode curr = groupStart;  
            // curr starts at groupStart

            // Reverse current group
            while (curr != nextGroupStart) {
                ListNode tmp = curr.next;  // Save next node
                curr.next = prev;          // Reverse link
                prev = curr;               // Move prev forward
                curr = tmp;                // Move curr forward
            }

            prevGroupEnd.next = kth;  
            // Connect prev group end to new group head
            prevGroupEnd = groupStart;  
            // Update prevGroupEnd to the new group's end
        }

        return dummy.next;  
        // Return new head (dummy.next)
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;  // Move forward
            k--;               // Decrease count
        }
        return curr;           // Return kth node or null
    }
}
