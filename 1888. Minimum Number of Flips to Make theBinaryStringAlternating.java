class Solution {
    public int minFlips(String s) {
        /*
        Sliding Window Approach
        
        Idea:
        We want to convert the string into an alternating string.
        Possible alternating patterns:
        1) 101010...
        2) 010101...

        Since the string can be rotated, we simulate rotation by
        iterating up to 2*n and using modulo to access characters.
        */

        int n = s.length();

        // Store the minimum flips required
        int mininumFlip = Integer.MAX_VALUE;

        // Counts how many characters mismatch with pattern starting with '1'
        int misMatchCount = 0;

        // Iterate through a virtual string of length 2*n to simulate rotations
        for(int i = 0; i < (2 * n); i++){

            // Get the real index in original string using modulo
            int r = i % n;

            // Check mismatch for pattern starting with '1'
            // Expected pattern: 1,0,1,0,1,0...
            // If current character doesn't match expected pattern, increment mismatch
            if((s.charAt(r) - '0') != (i % 2 == 0 ? 1 : 0)) 
                misMatchCount++;

            // If window size exceeds n, remove the leftmost element of the window
            // because we are sliding the window forward
            if(i >= n && (s.charAt(r) - '0') != (r % 2 == 0 ? 1 : 0)) 
                misMatchCount--;

            /*
            Once we have a full window of size n,
            calculate flips needed for both patterns:

            misMatchCount      -> flips needed if pattern starts with '1'
            n - misMatchCount  -> flips needed if pattern starts with '0'
            */

            if(i >= n - 1)
                mininumFlip = Math.min(mininumFlip, 
                        Math.min(misMatchCount, n - misMatchCount));
        }

        // Return minimum flips required
        return mininumFlip;
    }
}