class Solution {                         // Define the Solution class
    public long maxMatrixSum(int[][] matrix) {  // Method to find max possible matrix sum

        int min = Integer.MAX_VALUE;      // Store smallest absolute value
        long sum = 0;                     // Store total sum of absolute values
        int negCount = 0;                 // Count negative numbers

        for(int i = 0; i < matrix.length; i++)          // Loop through rows
        for(int j = 0; j < matrix[0].length; j++) {     // Loop through columns

            if(matrix[i][j] < 0)          // If value is negative
                negCount++;               // Increase negative count

            int ab = Math.abs(matrix[i][j]); // Convert value to absolute
            min = Math.min(min, ab);      // Update minimum absolute value
            sum += ab;                    // Add absolute value to sum
        }

        if(negCount % 2 == 0)             // If number of negatives is even
            return sum;                   // Maximum sum is total sum

        return sum - 2 * min;             // Reduce sum if negatives are odd
    }
}
