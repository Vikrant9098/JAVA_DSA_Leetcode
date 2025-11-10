class Solution {

    // Helper method to group indices of each value in nums
    private void groupIdx(List<List<Integer>> groups, int[] vals) {
        int pos = 0;                // Start index
        int n = vals.length;        // Length of array

        // Loop through array
        while (pos < n) {
            if (vals[pos] > 0) {    // Ignore zeros (already zero)
                groups.get(vals[pos]).add(pos);  // Add index to group of that value
            }
            pos++;                   // Move to next index
        }
    }

    // Count how many operations are needed for given positions
    private int countOperations(List<Integer> positions, FenwickTree tracker) {
        int ops = 0;               // Total operations
        int lastPos = -2;          // Last processed index
        int it = 0;                // Iterator
        int m = positions.size();  // Number of indices for current value

        // Loop through all positions of this value
        while (it < m) {
            int curr = positions.get(it);  // Current index

            // If first element or there is a zero gap between last and current
            if (lastPos == -2 || tracker.rangeCount(lastPos + 1, curr - 1) > 0) {
                ops++;                      // Need a new operation
            }

            lastPos = curr;                 // Update last processed index
            it++;                           // Move to next
        }

        // Mark all these positions as zero in Fenwick tree
        int j = 0;
        while (j < m) {
            tracker.mark(positions.get(j), 1);  // Mark index as zero
            j++;
        }

        return ops;   // Return total operations for this value
    }

    // Main function to calculate minimum operations
    public int minOperations(int[] nums) {
        int n = nums.length;  // Length of array
        int peak = 0, idx = 0;

        // Find the maximum value in array
        while (idx < n) {
            if (nums[idx] > peak) {
                peak = nums[idx];
            }
            idx++;
        }

        // Create list of lists to store indices for each value
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i <= peak + 5; i++) {
            groups.add(new ArrayList<>());
        }

        // Group indices by their value
        groupIdx(groups, nums);

        // Fenwick Tree to track which positions are already zero
        FenwickTree zeroTracker = new FenwickTree(n);

        // Mark all initial zeros in Fenwick Tree
        int i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                zeroTracker.mark(i, 1);
            }
            i++;
        }

        int res = 0;   // Result - total operations needed
        int val = 1;   // Start from value 1

        // Process all possible values
        while (val <= peak) {
            if (!groups.get(val).isEmpty()) {              // If value exists
                res += countOperations(groups.get(val), zeroTracker);  // Add its ops
            }
            val++;  // Move to next value
        }

        return res;  // Return final result
    }
}

// Fenwick Tree (Binary Indexed Tree) for range sum queries
class FenwickTree {
    private int[] BIT;  // BIT array
    private int len;    // Length of array

    // Constructor
    public FenwickTree(int size) {
        len = size;
        BIT = new int[size + 2];  // BIT needs 1-based indexing
    }

    // Add 'val' at index 'idx'
    public void mark(int idx, int val) {
        idx++;  // Convert to 1-based index
        while (idx <= len) {
            BIT[idx] += val;        // Update BIT node
            idx += (idx & -idx);    // Move to next responsible node
        }
    }

    // Get prefix sum from 0 to idx
    public int sum(int idx) {
        idx++;  // Convert to 1-based index
        int res = 0;
        while (idx > 0) {
            res += BIT[idx];        // Add current node value
            idx -= (idx & -idx);    // Move to parent node
        }
        return res;
    }

    // Get count of zeros between range [l, r]
    public int rangeCount(int l, int r) {
        if (l > r) return 0;        // Invalid range
        return sum(r) - sum(l - 1); // Range sum using prefix sums
    }
}
