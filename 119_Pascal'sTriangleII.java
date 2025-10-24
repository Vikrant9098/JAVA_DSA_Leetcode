import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Create a list to hold the current row
        List<Integer> row = new ArrayList<>();

        // Loop from 0 to rowIndex to build the desired row
        for (int i = 0; i <= rowIndex; i++) {
            // Add 1 at the end of the row for each iteration
            row.add(1);

            // Update the row values from right to left
            // so we don't overwrite the values we still need
            for (int j = i - 1; j > 0; j--) {
                // Each value is the sum of the two numbers above it
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        // Return the final row (the rowIndex-th row)
        return row;
    }
}
