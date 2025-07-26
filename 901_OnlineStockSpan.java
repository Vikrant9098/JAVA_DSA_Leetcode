import java.util.*;

// Class to implement StockSpanner logic
class StockSpanner {

    // Stack to store pairs of (price, span)
    private Stack<int[]> stack;

    // Constructor initializes the stack
    public StockSpanner() {
        stack = new Stack<>();
    }

    // Method to return the stock span for the current price
    public int next(int price) {
        int span = 1; // Start with span = 1 for the current day

        // While the current price is greater than or equal to the top of the stack
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the top element to current span
            span += stack.pop()[1];
        }

        // Push the current price and its span onto the stack
        stack.push(new int[]{price, span});

        // Return the computed span
        return span;
    }
}
