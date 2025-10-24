class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n]; // DP table to check if s[i..j] is palindrome
        int[] cuts = new int[n]; // cuts[i] = min cuts for substring s[0..i]

        for (int i = 0; i < n; i++) {
            int minCut = i; // maximum cuts = cut before every character
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true; // mark substring s[j..i] as palindrome
                    if (j == 0) {
                        minCut = 0; // whole substring s[0..i] is palindrome, no cut needed
                    } else {
                        minCut = Math.min(minCut, cuts[j - 1] + 1); // cut before j
                    }
                }
            }
            cuts[i] = minCut; // store minimum cuts for s[0..i]
        }

        return cuts[n - 1]; // minimum cuts for the whole string
    }
}
