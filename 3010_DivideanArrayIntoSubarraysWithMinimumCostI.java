class Solution { 
    // Declares a class named Solution (required by the platform, e.g., LeetCode)

    public int minimumCost(int[] A) { 
        // Method that takes an integer array A and returns the minimum cost as an int

        int a = 51, b = 51; 
        // Initialize two variables to store the smallest (a) and second smallest (b) values
        // 51 is used because array values are guaranteed to be ≤ 50 (acts like +infinity)

        for (int i = 1; i < A.length; i++) { 
            // Loop starts from index 1 because A[0] is always included separately in the result

            if (A[i] < a) { 
                // If current element is smaller than the smallest value found so far

                b = a; 
                // Move the previous smallest value into b (second smallest)

                a = A[i]; 
                // Update a with the new smallest value
            } 
            else if (A[i] < b) 
                // If current element is not smaller than a,
                // but smaller than the second smallest value b

                b = A[i]; 
                // Update b with the new second smallest value

            if (a == 1 && b == 1) break; 
            // Optimization: since 1 is the smallest possible value,
            // once both a and b become 1, no better pair can be found,
            // so we exit the loop early
        }

        return A[0] + a + b; 
        // Return the total minimum cost:
        // first element A[0] + smallest value a + second smallest value b
    }
}
