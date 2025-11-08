import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;          // get number of rows
        int cols = matrix[0].length;       // get number of columns
        int res = Integer.MIN_VALUE;       // store max sum <= k

        // loop through all possible left column boundaries
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];  // to store sum of each row between left and right

            // loop through all possible right column boundaries
            for (int right = left; right < cols; right++) {

                // add current column values to rowSum
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][right];
                }

                // TreeSet to store prefix sums for searching closest sum <= k
                TreeSet<Integer> prefixSums = new TreeSet<>();
                prefixSums.add(0);          // add base case (empty subarray)
                int currSum = 0;            // running sum for rows

                // check all possible row subarrays
                for (int sum : rowSum) {
                    currSum += sum;         // add current row sum
                    // find smallest prefix >= currSum - k
                    Integer target = prefixSums.ceiling(currSum - k);
                    if (target != null) {   // if such prefix exists
                        res = Math.max(res, currSum - target);  // update max sum
                    }
                    prefixSums.add(currSum); // store current prefix sum
                }
            }
        }

        return res; // return final max sum no larger than k
    }
}
