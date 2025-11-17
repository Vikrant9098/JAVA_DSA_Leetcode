class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        int last = -1;        // stores index of previous 1 (start with -1 meaning no 1 yet)

        for (int i = 0; i < nums.length; i++) {   // loop through all elements
            if (nums[i] == 1) {                   // if current element is 1
                
                if (last != -1 && (i - last - 1) < k) {  // check distance from previous 1
                    return false;                        // distance is too small → return false
                }

                last = i;          // update last position of 1
            }
        }

        return true;  // all 1s are properly spaced → return true
    }
}
