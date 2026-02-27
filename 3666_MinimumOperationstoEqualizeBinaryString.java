class Solution {
    public int minOperations(String s, int k) {
        int zero = 0;                  // Count of '0' characters in the string
        int len = s.length();          // Length of the string

        for (int i = 0; i < len; i++)  // Traverse the string
            zero += ~s.charAt(i) & 1;  // Clever trick: adds 1 if char is '0', adds 0 if char is '1'

        if (zero == 0)                 // If there are no zeros
            return 0;                  // No operation needed

        if (len == k)                  // If full string length equals k
            return (zero == len ? 1 : -1);  
            // If all characters are zero → 1 operation
            // Otherwise not possible → return -1

        int base = len - k;            // Remaining part size after selecting k

        int odd = Math.max(            // Compute operations assuming odd number of steps
            (zero + k - 1) / k,        // Minimum operations to handle zeros in k sized block (ceil division)
            (len - zero + base - 1) / base // Minimum operations to handle ones in remaining part (ceil division)
        );

        odd += ~odd & 1;               // Make sure odd is actually odd (force it to next odd if needed)

        int even = Math.max(           // Compute operations assuming even number of steps
            (zero + k - 1) / k,        // Minimum operations to handle zeros in k sized block
            (zero + base - 1) / base   // Minimum operations to handle zeros in remaining part
        );

        even += even & 1;              // Make sure even is actually even (force it to next even if needed)

        int res = Integer.MAX_VALUE;   // Store minimum valid result

        if ((k & 1) == (zero & 1))     // If parity of k and zero count matches
            res = Math.min(res, odd);  // Consider odd case

        if ((~zero & 1) == 1)          // If zero count is even
            res = Math.min(res, even); // Consider even case

        return res == Integer.MAX_VALUE ? -1 : res; 
        // If no valid result found return -1, otherwise return minimum operations
    }
}