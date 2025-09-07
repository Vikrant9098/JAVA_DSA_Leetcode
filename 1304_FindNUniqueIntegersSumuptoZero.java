class Solution {
    public int[] sumZero(int n) {
        // Create an array of size 'n' to hold the result
        int[] result = new int[n];
        
        // Index pointer to insert values into the array
        int index = 0;
        
        // Loop from 1 up to n/2
        // For each number i, add both -i and i to the array
        // This ensures their sum is always zero
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = -i; // Place negative number
            result[index++] = i;  // Place positive number
        }
        
        // If 'n' is odd, we still need one more number to make count = n
        // In that case, insert 0 (it won’t affect the sum)
        if (n % 2 == 1) {
            result[index] = 0;
        }
        
        // Return the final array
        return result;
    }
}
