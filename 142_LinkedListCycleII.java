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
    public ListNode detectCycle(ListNode head) {
        // Create two pointers to detect the cycle
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by 2 steps and slow by 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow one step
            fast = fast.next.next;    // move fast two steps

            // If they meet, a cycle exists
            if (slow == fast) {
                break;
            }
        }

        // If no cycle (fast reached the end), return null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move slow to head to find the start of the cycle
        slow = head;

        // Move both pointers one step at a time
        while (slow != fast) {
            slow = slow.next;  // move slow one step
            fast = fast.next;  // move fast one step
        }

        // The meeting point is the start of the cycle
        return slow;
    }
}
