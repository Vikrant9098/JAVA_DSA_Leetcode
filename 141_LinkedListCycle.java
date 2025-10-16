/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // If the list is empty or has only one node, no cycle is possible
        if (head == null || head.next == null) {
            return false;
        }
        
        // Initialize two pointers
        ListNode slow = head;       // moves 1 step at a time
        ListNode fast = head.next;  // moves 2 steps at a time
        
        // Traverse the list
        while (slow != fast) {
            // If fast reaches the end, there is no cycle
            if (fast == null || fast.next == null) {
                return false;
            }
            // Move slow by 1 step
            slow = slow.next;
            // Move fast by 2 steps
            fast = fast.next.next;
        }
        
        // If slow == fast, a cycle exists
        return true;
    }
}
