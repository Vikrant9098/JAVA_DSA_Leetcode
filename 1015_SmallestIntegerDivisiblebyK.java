class Solution {
    public int smallestRepunitDivByK(int k) {
        
        if (k % 2 == 0 || k % 5 == 0) 
            return -1; // numbers made of only '1' can never be divisible by 2 or 5

        int remainder = 0; // store current remainder
        for (int length = 1; length <= k; length++) { // maximum cycle length is k
            remainder = (remainder * 10 + 1) % k; // build next number ending with 1
            if (remainder == 0) 
                return length; // found the smallest length
        }

        return -1; // no valid number (should not happen for valid inputs)
    }
}
