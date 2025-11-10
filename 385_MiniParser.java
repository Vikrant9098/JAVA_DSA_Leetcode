/**
 * // This is the interface that allows for creating nested lists.
 * public interface NestedInteger {
 *     public NestedInteger();
 *     public NestedInteger(int value);
 *     public boolean isInteger();
 *     public Integer getInteger();
 *     public void setInteger(int value);
 *     public void add(NestedInteger ni);
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*; // import all utilities

class Solution {
    public NestedInteger deserialize(String s) {
        // if it's just a number (no brackets)
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s)); // return it as a single integer
        }

        Stack<NestedInteger> stack = new Stack<>(); // stack to store previous nested lists
        NestedInteger curr = null; // current nested list being created
        int l = 0; // start index for numbers

        // loop through each character of the string
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r); // current character

            if (ch == '[') { // if '[' found → start new list
                if (curr != null) stack.push(curr); // push old list to stack
                curr = new NestedInteger(); // create new empty list
                l = r + 1; // move left pointer to next position
            } 
            else if (ch == ']') { // if ']' found → end of list
                if (r > l) { // if number exists before ']'
                    int num = Integer.parseInt(s.substring(l, r)); // extract number
                    curr.add(new NestedInteger(num)); // add number to current list
                }
                if (!stack.isEmpty()) { // if stack not empty
                    NestedInteger parent = stack.pop(); // get parent list
                    parent.add(curr); // add current list to parent
                    curr = parent; // set parent as current
                }
                l = r + 1; // move left pointer forward
            } 
            else if (ch == ',') { // if ',' found → separate elements
                if (s.charAt(r - 1) != ']' && r > l) { // if number before comma
                    int num = Integer.parseInt(s.substring(l, r)); // extract number
                    curr.add(new NestedInteger(num)); // add number to current list
                }
                l = r + 1; // move left pointer after comma
            }
        }
        return curr; // return the final NestedInteger object
    }
}
