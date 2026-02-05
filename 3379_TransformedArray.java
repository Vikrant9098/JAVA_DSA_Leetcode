class Solution {                         // Define the Solution class

    public int[] constructTransformedArray(int[] A) { // Method that returns an int array
        int n = A.length;                // Store length of array A
        int[] res = new int[n];          // Create result array of same size

        for (int i = 0; i < n; i++)       // Loop through each index
            res[i] = A[(((i + A[i]) % n) + n) % n]; // Find valid index and copy value

        return res;                      // Return the transformed array
    }
}
