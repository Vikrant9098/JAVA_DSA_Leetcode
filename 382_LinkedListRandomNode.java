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
    List<Integer> values; // store all node values
    Random rand; // random object to pick random node

    public Solution(ListNode head) {
        values = new ArrayList<>(); // create list to hold values
        while (head != null) { // traverse linked list
            values.add(head.val); // add each node value to list
            head = head.next; // move to next node
        }
        rand = new Random(); // initialize random generator
    }
    
    public int getRandom() {
        int index = rand.nextInt(values.size()); // get random index
        return values.get(index); // return value at that index
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
