import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // convert list to set for fast lookup
        boolean[] dp = new boolean[s.length() + 1];    // dp[i] = true if s[0..i-1] can be segmented
        dp[0] = true;  // empty string can always be segmented

        // Check all prefixes of s
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0..j-1] can be segmented and s[j..i-1] is in dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further for this i
                }
            }
        }

        return dp[s.length()]; // return if entire string can be segmented
    }
}
