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
    public ListNode sortList(ListNode head) {
        // if list is empty or has one node, return as it's already sorted
        if (head == null || head.next == null) return head;
        
        // find the middle node of the linked list
        ListNode mid = getMiddle(head);
        
        // store the head of the right half
        ListNode rightHead = mid.next;
        
        // break the list into two halves
        mid.next = null;
        
        // sort the left half recursively
        ListNode left = sortList(head);
        
        // sort the right half recursively
        ListNode right = sortList(rightHead);
        
        // merge the two sorted halves
        return merge(left, right);
    }
    
    // function to find middle node using slow and fast pointer
    private ListNode getMiddle(ListNode head) {
        // slow and fast pointers start from head
        ListNode slow = head, fast = head.next;
        
        // move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;       // slow moves one step
            fast = fast.next.next;  // fast moves two steps
        }
        
        // when loop ends, slow is at the middle node
        return slow;
    }
    
    // function to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        // create a dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        
        // tail will point to the end of the merged list
        ListNode tail = dummy;
        
        // loop until one of the lists becomes empty
        while (l1 != null && l2 != null) {
            // if value in l1 is smaller, add it to merged list
            if (l1.val < l2.val) {
                tail.next = l1;     // connect l1 node to merged list
                l1 = l1.next;       // move l1 to next node
            } 
            // else add l2 node to merged list
            else {
                tail.next = l2;     // connect l2 node to merged list
                l2 = l2.next;       // move l2 to next node
            }
            tail = tail.next;       // move tail to next node
        }
        
        // connect any remaining nodes from l1
        if (l1 != null) tail.next = l1;
        
        // connect any remaining nodes from l2
        if (l2 != null) tail.next = l2;
        
        // return merged list starting from dummy.next
        return dummy.next;
    }
}
