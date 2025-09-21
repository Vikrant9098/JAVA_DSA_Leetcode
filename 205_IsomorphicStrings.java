class Solution {  // Define Solution class
    public boolean isIsomorphic(String s, String t) {  // Method to check if strings are isomorphic
        // Edge case: if lengths differ → can't be isomorphic
        if (s.length() != t.length()) return false;  // Return false immediately if lengths not equal

        // Create 2 maps (arrays) to track character mappings
        int[] mapS = new int[256];  // Mapping from s → t
        int[] mapT = new int[256];  // Mapping from t → s

        for (int i = 0; i < s.length(); i++) {  // Loop over all characters
            char chS = s.charAt(i);  // Current character in s
            char chT = t.charAt(i);  // Current character in t

            // If previous mappings don't match → not isomorphic
            if (mapS[chS] != mapT[chT]) {
                return false;  // Return false immediately
            }

            // Store mapping as (i + 1) to avoid default 0 confusion
            mapS[chS] = i + 1;  // Mark s character maps to t
            mapT[chT] = i + 1;  // Mark t character maps to s
        }

        return true;  // All checks passed → strings are isomorphic
    }
}
