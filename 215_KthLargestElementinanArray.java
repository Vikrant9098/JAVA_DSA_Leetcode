import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        // Min-heap to keep track of top k largest elements
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int no : nums)
        {
            queue.add(no);           // Add current number to the heap

            if(queue.size() > k)     // If heap size exceeds k
            {
                queue.remove();      // Remove the smallest element
            }
        }

        return queue.poll();         // Top of min-heap is the kth largest element
    }
}
