import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>(); // store indexes of useful elements
        int n = nums.length;
        int[] res = new int[n - k + 1]; // result array
        int idx = 0; // pointer for result index

        for (int i = 0; i < n; i++) {
            // remove elements from left if they are out of window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // remove smaller elements from right (they can’t be max)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // add current element index
            dq.offerLast(i);

            // once window size is reached, record max (front of deque)
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
