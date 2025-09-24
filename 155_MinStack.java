import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;     // main stack to store values
    private Stack<Integer> minStack;  // helper stack to track minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        // push value to main stack
        stack.push(val);
        // if minStack is empty or val <= current min, push to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // pop value from main stack
        int removed = stack.pop();
        // if popped value equals current min, pop from minStack too
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        // return top element from main stack
        return stack.peek();
    }
    
    public int getMin() {
        // return top element from minStack (the current min)
        return minStack.peek();
    }
}
