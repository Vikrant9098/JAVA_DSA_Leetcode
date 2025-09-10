class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // If needle is longer than haystack, impossible to find
        if (nLen > hLen) {
            return -1;
        }

        // Loop through haystack until there's enough room for needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if substring matches needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i; // Found at index i
            }
        }

        // If not found
        return -1;
    }
}
