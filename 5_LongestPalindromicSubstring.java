class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;  // to store the start and end of longest palindrome

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // odd-length palindrome
            int len2 = expandFromCenter(s, i, i + 1);   // even-length palindrome
            int len = Math.max(len1, len2);             // pick the longer one

            if (len > end - start) {  // if new palindrome is longer, update start and end
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);  // return longest palindromic substring
    }

    private int expandFromCenter(String s, int left, int right) {
        // expand as long as it is a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;  // length of palindrome
    }
}
