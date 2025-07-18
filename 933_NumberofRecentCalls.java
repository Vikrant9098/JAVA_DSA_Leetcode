import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    // Queue to store timestamps of ping requests
    private Queue<Integer> queue;

    public RecentCounter() {
        // Initialize the queue
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the current ping time to the queue
        queue.add(t);

        // Remove all pings that are outside the 3000 ms time window
        while (queue.peek() < t - 3000) {
            queue.poll(); // Remove the oldest ping
        }

        // Return the number of pings in the time window [t - 3000, t]
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
