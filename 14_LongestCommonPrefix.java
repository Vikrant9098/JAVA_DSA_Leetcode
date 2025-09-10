class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if array is empty, return ""
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume first string is the prefix
        String prefix = strs[0];

        // Loop over the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // While current string does not start with prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce prefix by removing last character
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
