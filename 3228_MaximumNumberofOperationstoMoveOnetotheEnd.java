class Solution {
    public int maxOperations(String s) {
        int ones = 0, res = 0;       // ones = count of '1's seen so far, res = total operations
        
        for (int i = 0; i < s.length(); i++) {   // loop through each character in the string
            if (s.charAt(i) == '1')              // if current character is '1'
                ones++;                           // increase count of ones
            else if (i > 0 && s.charAt(i - 1) == '1') // if current is '0' and previous is '1'
                res += ones;                      // add all previous ones to result (each can move)
        }
        
        return res;                              // return total number of operations
    }
}
