class Solution { // Start of the Solution class definition.
    public List<Boolean> prefixesDivBy5(int[] nums) { // Method to check if binary prefixes are divisible by 5.
        List<Boolean> res = new ArrayList<>(); // Initialize a list to store the boolean results.
        int val = 0; // Initialize an integer to hold the remainder of the current prefix when divided by 5.

        for (int n : nums) { // Loop through each binary digit (0 or 1) in the input array 'nums'.
            // The core idea is to update the remainder using modular arithmetic.
            // (val << 1) is equivalent to (val * 2), which is the new prefix value
            // before adding the current digit 'n'.
            // Adding 'n' completes the new prefix's value.
            // The whole expression is then taken modulo 5 to keep the number small.
            val = ((val << 1) + n) % 5; 
            res.add(val == 0); // Add true if the current remainder is 0 (divisible by 5), otherwise add false.
        }

        return res; // Return the list of boolean results.
    }
}