class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0; // To store the length of the last word
        int i = s.length() - 1; // Start from the end of the string

        // Step 1: Skip all trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        // Step 3: Return the final length
        return length;
    }
}
