class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // store last index of each character
        boolean[] seen = new boolean[26]; // track if character already in result

        // fill last index for each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder(); // use as a stack (result builder)

        // go through each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // skip if already in result
            if (seen[c - 'a']) continue;

            // remove characters that are bigger than current and appear later
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1)
                    && lastIndex[sb.charAt(sb.length() - 1) - 'a'] > i) {
                seen[sb.charAt(sb.length() - 1) - 'a'] = false; // mark as not seen
                sb.deleteCharAt(sb.length() - 1); // remove from result
            }

            sb.append(c); // add current character
            seen[c - 'a'] = true; // mark as seen
        }

        return sb.toString(); // return final string
    }
}
