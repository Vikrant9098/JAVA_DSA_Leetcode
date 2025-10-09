import java.util.*;

class MedianFinder {

    // Max-heap to store the smaller half of numbers
    private PriorityQueue<Integer> maxHeap;
    // Min-heap to store the larger half of numbers
    private PriorityQueue<Integer> minHeap;

    /** Initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        minHeap = new PriorityQueue<>(); // min-heap
    }
    
    /** Adds a number into the data structure. */
    public void addNum(int num) {
        // Add number to maxHeap first
        maxHeap.offer(num);
        // Balance: move the largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());
        
        // Maintain size property: maxHeap can have same or 1 more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    /** Returns the median of current data stream */
    public double findMedian() {
        // If odd number of elements, maxHeap has one extra element → median = top of maxHeap
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // If even, median = average of tops of both heaps
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
