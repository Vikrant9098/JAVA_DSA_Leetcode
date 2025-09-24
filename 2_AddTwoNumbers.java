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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify code (head of result list)
        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // pointer to build result
        int carry = 0;            // carry for sums > 9
        
        // Traverse both lists until both are null
        while (l1 != null || l2 != null) {
            // Get current values or 0 if list is exhausted
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Sum the two digits and the carry
            int sum = x + y + carry;
            
            // Update carry for next iteration
            carry = sum / 10;
            
            // Create new node for current digit
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            // Move to next nodes
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // If carry remains after final addition, add new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // Return head of result list (skip dummy node)
        return dummy.next;
    }
}
