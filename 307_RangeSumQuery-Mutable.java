class NumArray {
    private int[] nums;     // stores original array
    private int[] bit;      // Fenwick Tree array
    private int n;          // size of array

    public NumArray(int[] nums) {
        this.nums = nums;          // store original array
        this.n = nums.length;      // get array length
        this.bit = new int[n + 1]; // create BIT (1-indexed)
        
        // build the Fenwick Tree
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);      // initialize BIT with each number
        }
    }

    // function to update BIT at index i by delta
    private void init(int i, int val) {
        i++; // convert to 1-indexed
        while (i <= n) {
            bit[i] += val; // add value to current node
            i += (i & -i); // move to next index in BIT
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index]; // find the change in value
        nums[index] = val;            // update the actual array
        init(index, diff);            // update the BIT with the difference
    }

    private int getSum(int i) {
        int sum = 0;
        i++; // convert to 1-indexed
        while (i > 0) {
            sum += bit[i];  // add value from current BIT node
            i -= (i & -i);  // move to parent index
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        // sum in range = prefixSum(right) - prefixSum(left - 1)
        return getSum(right) - getSum(left - 1);
    }
}
