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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // empty or single node is palindrome

        // Step 1: Find middle using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;       // move slow one step
            fast = fast.next.next;  // move fast two steps
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare first half and reversed second half
        ListNode firstHalf = head;
        ListNode tempSecond = secondHalf;
        boolean palindrome = true;
        while (palindrome && tempSecond != null) {
            if (firstHalf.val != tempSecond.val) { // mismatch found
                palindrome = false;
            }
            firstHalf = firstHalf.next;   // move first half pointer
            tempSecond = tempSecond.next; // move second half pointer
        }

        // Step 4 (optional): Restore the list to original
        slow.next = reverse(secondHalf);

        return palindrome; // return result
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // store next node
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev forward
            curr = nextTemp;               // move curr forward
        }
        return prev; // new head of reversed list
    }
}
