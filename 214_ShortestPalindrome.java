class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;   // if empty or single char, it's already palindrome

        String rev = new StringBuilder(s).reverse().toString(); // reverse the string
        String combined = s + "#" + rev;              // combine both with a separator
        int[] lps = buildLPS(combined);               // build KMP prefix table

        int longestPalPrefix = lps[combined.length() - 1]; // length of longest palindromic prefix
        String add = rev.substring(0, rev.length() - longestPalPrefix); // part to add in front
        return add + s;                               // return final shortest palindrome
    }

    // function to build LPS (Longest Prefix Suffix) array like in KMP algorithm
    private int[] buildLPS(String str) {
        int n = str.length();     // length of combined string
        int[] lps = new int[n];   // LPS array
        int len = 0;              // length of previous longest prefix suffix
        int i = 1;                // start from second character

        while (i < n) {           // loop till end
            if (str.charAt(i) == str.charAt(len)) {  // if chars match
                len++;                               // increase length
                lps[i] = len;                        // store in LPS
                i++;                                 // move ahead
            } else {                                 // if chars don't match
                if (len > 0) {                       // try previous prefix
                    len = lps[len - 1];
                } else {                             // no prefix found
                    lps[i] = 0;                      // set 0
                    i++;                             // move ahead
                }
            }
        }
        return lps;               // return the LPS array
    }
}
