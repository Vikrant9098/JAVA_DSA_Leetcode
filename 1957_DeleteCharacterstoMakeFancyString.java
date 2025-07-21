class Solution {
    public String makeFancyString(String s) {
        // Use StringBuilder to efficiently build the result string
        StringBuilder result = new StringBuilder();

        // Loop through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // Check if the last two characters in result are equal to the current character
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i)) {
                // If adding this character would make three consecutive characters, skip it
                continue;
            }

            // Otherwise, add the current character to result
            result.append(s.charAt(i));
        }

        // Convert StringBuilder to string and return
        return result.toString();
    }
}
