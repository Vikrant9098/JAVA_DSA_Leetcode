class Solution { 
    // Defines a class named Solution

    public int repeatedNTimes(int[] A) {
        // Method that returns the number repeated N times in the array A

        for (int i = 0; i < A.length - 2; i++) {
            // Loop through the array till the third last element

            if (A[i] == A[i + 1] || A[i] == A[i + 2]) {
                // Check if current element equals the next
                // OR equals the element after next

                return A[i];
                // If found repeated, return that number immediately
            }
        }

        return A[A.length - 1];
        // If not found in loop, return the last element
        // (it must be the repeated one)
    }
}
