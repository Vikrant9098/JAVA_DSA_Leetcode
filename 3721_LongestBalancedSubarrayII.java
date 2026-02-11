class SegmentTree {
    int n; // Size of array
    int[] minTree, maxTree, lazy; // Segment tree arrays

    public SegmentTree(int n) {
        this.n = n; // Store size
        minTree = new int[4 * n]; // Store minimum values
        maxTree = new int[4 * n]; // Store maximum values
        lazy = new int[4 * n]; // Store lazy updates
    }

    // Push pending updates to current node
    private void push(int node, int start, int end) {
        if (lazy[node] != 0) { // If there is a pending update
            minTree[node] += lazy[node]; // Update min value
            maxTree[node] += lazy[node]; // Update max value

            // If not a leaf node, pass update to children
            if (start != end) {
                lazy[2 * node] += lazy[node]; // Left child
                lazy[2 * node + 1] += lazy[node]; // Right child
            }

            lazy[node] = 0; // Clear lazy value
        }
    }

    // Update range [l, r] by adding val
    public void updateRange(int node, int start, int end, int l, int r, int val) {
        push(node, start, end); // Apply pending updates

        // No overlap
        if (start > end || start > r || end < l) {
            return;
        }

        // Total overlap
        if (l <= start && end <= r) {
            lazy[node] += val; // Mark lazy update
            push(node, start, end); // Apply it
            return;
        }

        int mid = (start + end) / 2; // Middle index

        // Update left child
        updateRange(2 * node, start, mid, l, r, val);

        // Update right child
        updateRange(2 * node + 1, mid + 1, end, l, r, val);

        // Update current node values from children
        minTree[node] = Math.min(minTree[2 * node], minTree[2 * node + 1]);
        maxTree[node] = Math.max(maxTree[2 * node], maxTree[2 * node + 1]);
    }

    // Find leftmost index where value becomes 0
    public int findLeftmostZero(int node, int start, int end) {
        push(node, start, end); // Apply pending updates

        // If no zero possible in this range
        if (minTree[node] > 0 || maxTree[node] < 0) {
            return -1;
        }

        // If leaf node
        if (start == end) {
            return minTree[node] == 0 ? start : -1; // Return index if zero
        }

        int mid = (start + end) / 2; // Middle index

        // Try left side first
        int left = findLeftmostZero(2 * node, start, mid);
        if (left != -1) return left;

        // Otherwise try right side
        return findLeftmostZero(2 * node + 1, mid + 1, end);
    }
}

public class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length; // Size of array
        Map<Integer, Integer> prev = new HashMap<>(); // Store last occurrence

        SegmentTree st = new SegmentTree(n); // Create segment tree
        int res = 0; // Store max length

        // Traverse from left to right
        for (int r = 0; r < n; r++) {
            int v = nums[r]; // Current number

            // +1 if even, -1 if odd
            int val = (v % 2 == 0) ? 1 : -1;

            // If number appeared before
            if (prev.containsKey(v)) {
                // Remove previous contribution
                st.updateRange(1, 0, n - 1, 0, prev.get(v), -val);
            }

            // Add current contribution
            st.updateRange(1, 0, n - 1, 0, r, val);

            prev.put(v, r); // Update last occurrence

            // Find leftmost zero prefix
            int l = st.findLeftmostZero(1, 0, n - 1);

            // If valid subarray found
            if (l != -1 && l <= r) {
                res = Math.max(res, r - l + 1); // Update answer
            }
        }

        return res; // Return result
    }
}
