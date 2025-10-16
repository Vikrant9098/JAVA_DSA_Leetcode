/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, no intersection
        if (headA == null || headB == null) {
            return null;
        }

        // Create two pointers to traverse both lists
        ListNode a = headA;
        ListNode b = headB;

        // Move both pointers until they meet or both become null
        while (a != b) {
            // Move to next node or switch to other list's head when reaching end
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either they meet at intersection node or both are null (no intersection)
        return a;
    }
}
