/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     public boolean isInteger();          // returns true if holds a single integer
 *     public Integer getInteger();         // returns the integer value
 *     public List<NestedInteger> getList();// returns the nested list
 * }
 */
import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flatList;  // to store all integers in order
    private int index;               // pointer to current position

    public NestedIterator(List<NestedInteger> nestedList) {
        flatList = new ArrayList<>();  // initialize list
        index = 0;                     // start index at 0
        flatten(nestedList);           // flatten nested list into flatList
    }

    // helper function to flatten nested list
    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) { // go through each element
            if (ni.isInteger()) {              // if it's a single integer
                flatList.add(ni.getInteger()); // add to flatList
            } else {                           // if it's a list
                flatten(ni.getList());         // call flatten again (recursion)
            }
        }
    }

    @Override
    public Integer next() {
        return flatList.get(index++);  // return current element and move pointer
    }

    @Override
    public boolean hasNext() {
        return index < flatList.size(); // true if more elements left
    }
}