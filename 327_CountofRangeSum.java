class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // create prefix sum array (one extra space for 0)
        long[] prefix = new long[nums.length + 1];

        // fill prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i]; // prefix[i+1] = sum of first (i+1) elements
        }

        // call helper to count valid range sums
        return countWhileMerge(prefix, 0, prefix.length, lower, upper);
    }

    private int countWhileMerge(long[] prefix, int left, int right, int lower, int upper) {
        // base case: if only one element, no range to count
        if (right - left <= 1) return 0;

        // find middle index
        int mid = (left + right) / 2;

        // count in left and right halves
        int count = countWhileMerge(prefix, left, mid, lower, upper)
                  + countWhileMerge(prefix, mid, right, lower, upper);

        // pointers to track ranges in right half
        int j = mid, k = mid, t = mid;

        // temporary array to help in merging
        long[] temp = new long[right - left];

        // index for temp array
        int r = 0;

        // loop through each element in left half
        for (int i = left; i < mid; i++) {

            // move k to find first valid prefix (prefix[k] - prefix[i] >= lower)
            while (k < right && prefix[k] - prefix[i] < lower) k++;

            // move j to find last valid prefix (prefix[j] - prefix[i] <= upper)
            while (j < right && prefix[j] - prefix[i] <= upper) j++;

            // count all valid ranges for current i
            count += j - k;

            // merge smaller elements into temp
            while (t < right && prefix[t] < prefix[i]) temp[r++] = prefix[t++];

            // add current left element to temp
            temp[r++] = prefix[i];
        }

        // copy remaining right elements
        System.arraycopy(prefix, t, temp, r, right - t);

        // copy merged temp array back into prefix
        System.arraycopy(temp, 0, prefix, left, temp.length);

        // return total count of valid range sums
        return count;
    }
}
