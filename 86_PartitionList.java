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
    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes for < x and >= x lists
        ListNode beforeDummy = new ListNode(0);  
        ListNode afterDummy = new ListNode(0);

        // Pointers to build two lists
        ListNode before = beforeDummy;  
        ListNode after = afterDummy;

        while (head != null) {
            if (head.val < x) {
                before.next = head;  
                // Add node to 'before' list
                before = before.next;  
                // Move 'before' pointer
            } else {
                after.next = head;  
                // Add node to 'after' list
                after = after.next;  
                // Move 'after' pointer
            }
            head = head.next;  
            // Move to next node
        }

        after.next = null;  
        // End 'after' list to avoid cycle
        before.next = afterDummy.next;  
        // Connect 'before' list with 'after' list

        return beforeDummy.next;  
        // Return new head of partitioned list
    }
}
