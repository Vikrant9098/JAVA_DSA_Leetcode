import java.util.*;  // Import utility classes for PriorityQueue and HashSet

// Class representing the smallest infinite set logic
class SmallestInfiniteSet {

    private PriorityQueue<Integer> minHeap; // Min-heap to store added-back numbers in sorted order
    private Set<Integer> set;               // Set to avoid duplicates in the heap
    private int next;                       // Points to the next smallest natural number

    // Constructor to initialize data structures
    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();    // Initializes the min-heap
        set = new HashSet<>();              // Initializes the set
        next = 1;                           // Starts the sequence from 1
    }

    // Returns and removes the smallest number from the set
    public int popSmallest() {
        if (!minHeap.isEmpty()) {           // If there are any numbers added back
            int val = minHeap.poll();       // Remove and get the smallest from the heap
            set.remove(val);                // Remove it from the set as it's no longer in the heap
            return val;                     // Return the value
        }

        return next++;                      // Else return the next natural number and increment
    }

    // Adds a number back to the set if it's smaller than 'next' and not already in the heap
    public void addBack(int num) {
        if (num < next && set.add(num)) {   // Add only if num is smaller than 'next' and not in the set
            minHeap.offer(num);             // Add it to the heap
        }
    }
}

/**
 * Example usage:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int smallest = obj.popSmallest();
 * obj.addBack(3);
 */
