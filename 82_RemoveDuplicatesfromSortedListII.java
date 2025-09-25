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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);  
        // Dummy node before head (helps handle cases when head itself is duplicate)

        ListNode prev = dummy;  
        // Pointer to track the last node before current duplicates group

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                // Found duplicates (two consecutive nodes have same value)
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;  
                    // Skip all nodes with this duplicate value
                }
                prev.next = head.next;  
                // Connect prev to node after duplicates
            } else {
                prev = prev.next;  
                // No duplicate, move prev forward
            }
            head = head.next;  
            // Move head forward
        }

        return dummy.next;  
        // Return new head (after dummy)
    }
}
