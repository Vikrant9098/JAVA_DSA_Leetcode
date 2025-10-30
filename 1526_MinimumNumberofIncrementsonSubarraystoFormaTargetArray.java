class Solution {
    public int minNumberOperations(int[] target) {
        int operations = target[0];  // Start with first element value as initial operations
        
        // Loop through the array from second element
        for (int i = 1; i < target.length; i++) {
            // If current value is greater than previous value
            if (target[i] > target[i - 1]) {
                // Add the difference to operations (extra increments needed)
                operations += target[i] - target[i - 1];
            }
        }
        
        return operations;  // Return total operations needed
    }
}
