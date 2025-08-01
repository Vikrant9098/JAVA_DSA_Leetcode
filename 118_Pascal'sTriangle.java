import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> triangle = new ArrayList<>(); // Create a list to store the entire Pascal's Triangle

        // Iterate through each row from 0 to numRows - 1
        for (int i = 0; i < numRows; i++)
        {
            List<Integer> row = new ArrayList<>(); // Create a new row

            row.add(1); // The first element of each row is always 1

            // Fill the middle elements of the row using values from the previous row
            for (int j = 1; j < i; j++) 
            {
                // Each middle element is the sum of the two numbers directly above it in the previous row
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                
                row.add(value); // Add the computed value to the row
            }

            // The last element of each row (except the first row) is always 1
            if (i > 0) row.add(1);

            // Add the completed row to the triangle
            triangle.add(row);
        }
        
        return triangle; // Return the full Pascal's Triangle
    }
}
