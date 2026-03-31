import java.util.Arrays;

class Solution {
    public String generateString(String S, String t) {

        // Convert string S to char array for easy access
        char[] s = S.toCharArray();

        int n = s.length;     // length of S
        int m = t.length();   // length of pattern t

        // Result array of size n + m - 1 (final constructed string)
        char[] ans = new char[n + m - 1];

        // Fill with '?' to mark undecided positions
        Arrays.fill(ans, '?');


        // Step 1: Handle 'T' (True conditions)
        for (int i = 0; i < n; i++) {

            // Skip if not 'T'
            if (s[i] != 'T') {
                continue;
            }

            // For 'T', substring starting at i must match string t
            for (int j = 0; j < m; j++) {

                char v = ans[i + j]; // current value in result

                // If already filled and mismatch occurs → invalid
                if (v != '?' && v != t.charAt(j)) {
                    return "";
                }

                // Otherwise, enforce match with t
                ans[i + j] = t.charAt(j);
            }
        }


        // Save original state (to track which were '?' initially)
        char[] oldAns = ans.clone();


        // Replace remaining '?' with 'a' (default smallest character)
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
            }
        }


        // Step 2: Handle 'F' (False conditions)
        for (int i = 0; i < n; i++) {

            // Skip if not 'F'
            if (s[i] != 'F') {
                continue;
            }

            // Check if substring equals t (this should NOT happen)
            if (!new String(ans, i, m).equals(t)) {
                continue; // already different → OK
            }

            // Try to break the match by modifying one character
            boolean ok = false;

            // Traverse from right to left in substring
            for (int j = i + m - 1; j >= i; j--) {

                // Only modify positions that were originally '?'
                if (oldAns[j] == '?') {

                    // Change 'a' → 'b' to break equality
                    ans[j] = 'b';
                    ok = true;
                    break;
                }
            }

            // If no position can be changed, impossible
            if (!ok) {
                return "";
            }
        }


        // Convert final char array to string and return
        return new String(ans);
    }
}