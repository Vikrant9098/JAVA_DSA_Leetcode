class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        // Total number of workers
        int n = costs.length;

        // Min-heap for candidates from the left side
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        // Min-heap for candidates from the right side
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        // Left and right pointers for the range of workers
        int i = 0;          // Start of the list
        int j = n - 1;      // End of the list

        // Fill the left heap with first 'candidates' workers
        while (i <= j && leftHeap.size() < candidates) {
            leftHeap.add(costs[i]);  // Add cost of worker from start
            i++;                     // Move left pointer forward
        }

        // Fill the right heap with last 'candidates' workers
        while (j >= i && rightHeap.size() < candidates) {
            rightHeap.add(costs[j]); // Add cost of worker from end
            j--;                     // Move right pointer backward
        }

        // Total cost accumulated for hiring k workers
        long totalCost = 0;

        // Repeat the hiring process k times
        for (int hired = 0; hired < k; hired++) {
            // If both heaps have candidates
            if (!leftHeap.isEmpty() && !rightHeap.isEmpty()) {
                // Compare smallest cost from both sides
                if (leftHeap.peek() <= rightHeap.peek()) {
                    totalCost += leftHeap.poll();  // Hire from left
                    if (i <= j) {
                        leftHeap.add(costs[i]);    // Add next candidate to left heap
                        i++;                        // Move pointer
                    }
                } else {
                    totalCost += rightHeap.poll(); // Hire from right
                    if (i <= j) {
                        rightHeap.add(costs[j]);   // Add next candidate to right heap
                        j--;                        // Move pointer
                    }
                }
            }
            // If only left heap has candidates
            else if (!leftHeap.isEmpty()) {
                totalCost += leftHeap.poll();      // Hire from left
                if (i <= j) {
                    leftHeap.add(costs[i]);        // Add next left candidate
                    i++;                            // Move pointer
                }
            }
            // If only right heap has candidates
            else {
                totalCost += rightHeap.poll();     // Hire from right
                if (i <= j) {
                    rightHeap.add(costs[j]);       // Add next right candidate
                    j--;                            // Move pointer
                }
            }
        }

        // Return total cost after hiring k workers
        return totalCost;
    }
}
