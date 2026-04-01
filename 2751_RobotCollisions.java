import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String d) {

        int n = pos.length;

        // Store indices of robots (0 to n-1)
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        // Sort indices based on robot positions (left → right)
        Arrays.sort(order, (a, b) -> pos[a] - pos[b]);

        // Track whether each robot is alive
        boolean[] alive = new boolean[n];
        Arrays.fill(alive, true);

        // Stack to store indices of robots moving to the right
        Deque<Integer> st = new ArrayDeque<>();

        // Traverse robots in sorted order of positions
        for (int idx : order) {

            // If robot is moving RIGHT → push into stack
            if (d.charAt(idx) == 'R') {
                st.push(idx);
            }
            // If robot is moving LEFT → possible collisions
            else {

                // Process collisions with previous RIGHT-moving robots
                while (!st.isEmpty()) {

                    int top = st.peek(); // top robot moving right

                    // Case 1: current robot has more health
                    if (h[top] < h[idx]) {
                        alive[top] = false; // right robot dies
                        st.pop();           // remove it
                        h[idx]--;           // left robot loses 1 health
                    }
                    // Case 2: stack robot has more health
                    else if (h[top] > h[idx]) {
                        alive[idx] = false; // current robot dies
                        h[top]--;           // right robot loses 1 health
                        break;              // collision ends
                    }
                    // Case 3: equal health → both die
                    else {
                        alive[top] = false;
                        alive[idx] = false;
                        st.pop();
                        break;
                    }
                }
            }
        }

        // Collect health of all surviving robots
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (alive[i]) res.add(h[i]);

        return res;
    }
}