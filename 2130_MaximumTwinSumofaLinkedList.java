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
    public int pairSum(ListNode head) {
        // Step 1: Use fast and slow pointer to reach the middle of the list
        ListNode slow = head;         // Slow pointer starts at head
        ListNode fast = head;         // Fast pointer also starts at head

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Slow moves one step
            fast = fast.next.next;    // Fast moves two steps
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;         // Will hold the reversed list
        while (slow != null) {
            ListNode nextNode = slow.next; // Temporarily store the next node
            slow.next = prev;             // Reverse the current node's pointer
            prev = slow;                  // Move prev one step forward
            slow = nextNode;              // Move to the next node in original list
        }

        // Step 3: Find the max twin sum by traversing both halves
        int maxSum = 0;                  // Store the max twin sum
        ListNode first = head;          // Start from head (first half)
        ListNode second = prev;         // Start from reversed second half

        while (second != null) {        // Traverse till end of second half
            int sum = first.val + second.val; // Calculate twin sum
            maxSum = Math.max(maxSum, sum);   // Update max sum
            first = first.next;         // Move to next node in first half
            second = second.next;       // Move to next node in second half
        }

        return maxSum; // Return the maximum twin sum found
    }
}
