class Solution {
    public int binaryGap(int n) {   
        int i = 0;          // i tells us which position we are at (like counting steps)
        int cnt = 0;        // cnt counts how many 1's we have seen
        int idx = 0;        // idx remembers where the last 1 was found
        int gap = 0;        // gap stores the biggest distance between two 1's

        while (n != 0) {    // keep checking until all bits are finished
            
            // check if the last bit (rightmost bit) is 1
            if ((n & 1) == 1) {  
                
                // if we have already seen a 1 before
                if (cnt != 0) {
                    // find distance between this 1 and last 1
                    // and keep the biggest distance
                    gap = Math.max(gap, i - idx);     
                }

                // remember this position as last 1 position
                idx = i;

                // increase count because we found a 1
                cnt++;
            }

            // move to next bit (shift right)
            n = n >> 1;

            // move to next position
            i++;
        }

        // return the biggest distance between two 1's
        return gap;
    }
}