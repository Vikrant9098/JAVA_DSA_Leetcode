import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // Edge case: if either string is null or s is smaller than t, no window possible
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Frequency map for all characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        // Map to store frequency of characters in current sliding window
        Map<Character, Integer> windowMap = new HashMap<>();
        
        int left = 0;  // Left pointer of sliding window
        int right = 0; // Right pointer of sliding window
        int required = tMap.size(); // Number of unique characters in t that must be matched
        int formed = 0; // Number of unique characters in current window that meet the required frequency
        
        // Array to store the best answer [window length, left index, right index]
        int[] ans = {-1, 0, 0};
        
        // Expand the window by moving right pointer
        while (right < s.length()) {
            char c = s.charAt(right); // Current character at right
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1); // Add to window frequency map
            
            // If current character frequency matches required frequency in t
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++; // One more unique character fully matched
            }
            
            // Try shrinking the window from left as long as all required characters are matched
            while (left <= right && formed == required) {
                // Update answer if this window is smaller than previous best
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                // Remove character at left from window and move left pointer
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                // If removed character was required and frequency drops below required → decrement formed
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    formed--;
                }
                
                left++; // Move left pointer forward
            }
            
            right++; // Expand window by moving right pointer
        }
        
        // If no valid window found, return empty string, else return substring
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
