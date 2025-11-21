class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();  // store length of string
        int result = 0;      // variable to store final count

        // loop through each character from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int left = -1;     // to store first position of ch
            int right = -1;    // to store last position of ch

            // find first and last occurrence of ch in string
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {  // if current character is ch
                    if (left == -1) left = i;  // set first position if not set
                    right = i;   // update last position continuously
                }
            }

            // check if we have two same ends and space in between
            if (left != -1 && right != -1 && right - left > 1) {
                boolean[] visited = new boolean[26];  // array to mark unique middle characters

                // check all characters between left and right
                for (int j = left + 1; j < right; j++) {
                    visited[s.charAt(j) - 'a'] = true;  // mark character as seen
                }

                // count unique middle characters
                for (boolean v : visited) {
                    if (v) result++;  // increase count if true
                }
            }
        }

        return result;  // return final answer
    }
}
