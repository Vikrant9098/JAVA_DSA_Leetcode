class Solution {
    public int numSub(String s) {
        
        long MOD = 1000000007;   // modulo value
        long count = 0;          // to count consecutive 1's
        long ans = 0;            // to store final answer
        
        // loop through each character
        for (char c : s.toCharArray()) {
            
            if (c == '1') {          // if current char is '1'
                count++;             // increase continuous 1's count
                ans = (ans + count) % MOD;  // add new substrings formed
            } else {
                count = 0;           // reset count when '0' appears
            }
        }
        
        return (int) ans;            // return final result
    }
}
