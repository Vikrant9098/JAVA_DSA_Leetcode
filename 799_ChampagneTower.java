class Solution {  // Define the Solution class

    public double champagneTower(int poured, int query_row, int query_glass) {  
        // Method to calculate how much champagne is in a specific glass

        double[][] tower = new double[102][102];  
        // Create a 2D array to represent the champagne tower (max 100 rows)

        tower[0][0] = (double) poured;  
        // Pour all champagne into the top glass

        for (int r = 0; r <= query_row; r++) {  
            // Loop through each row until the required row

            for (int c = 0; c <= r; c++) {  
                // Loop through each glass in the current row

                if (tower[r][c] > 1.0) {  
                    // If current glass overflows (capacity is 1)

                    double excess = (tower[r][c] - 1.0) / 2.0;  
                    // Calculate extra champagne and split into 2 parts

                    tower[r][c] = 1.0;  
                    // Fill current glass to maximum capacity (1)

                    tower[r + 1][c] += excess;  
                    // Add half of excess to left glass below

                    tower[r + 1][c + 1] += excess;  
                    // Add half of excess to right glass below
                }
            }
        }

        return tower[query_row][query_glass];  
        // Return the amount in the requested glass
    }
}
