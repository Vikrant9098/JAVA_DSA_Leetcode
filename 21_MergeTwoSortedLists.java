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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        
        // Keep track of current position in merged list
        ListNode current = dummy;
        
        // Traverse both lists while neither is empty
        while (list1 != null && list2 != null) {
            // Compare values and attach smaller node
            if (list1.val <= list2.val) {
                // Attach list1 node to merged list
                current.next = list1;
                // Move to next node in list1
                list1 = list1.next;
            } else {
                // Attach list2 node to merged list
                current.next = list2;
                // Move to next node in list2
                list2 = list2.next;
            }
            // Move current pointer forward
            current = current.next;
        }
        
        // Attach remaining nodes from non-empty list
        current.next = (list1 != null) ? list1 : list2;
        
        // Return head of merged list (skip dummy node)
        return dummy.next;
    }
}

/*
Example usage:
list1 = [1,2,4], list2 = [1,3,4]
result = mergeTwoLists(list1, list2);  // [1,1,2,3,4,4]

list1 = [], list2 = []
result = mergeTwoLists(list1, list2);  // []

list1 = [], list2 = [0]
result = mergeTwoLists(list1, list2);  // [0]
*/