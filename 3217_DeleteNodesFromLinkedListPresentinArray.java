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
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Store all values from nums in a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node to handle cases where head needs to be deleted
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers: prev (previous node) and curr (current node)
        ListNode prev = dummy;
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {
            if (set.contains(curr.val)) {
                // If current node value exists in set, skip it
                prev.next = curr.next;
            } else {
                // Otherwise, move prev forward
                prev = curr;
            }
            curr = curr.next; // Move current node forward
        }

        // Return the modified list starting from dummy.next
        return dummy.next;
    }
}
