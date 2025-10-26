class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        // Iterate over each character in the string
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            // Convert character to number
            int value = c - 'A' + 1;
            // Multiply previous result by 26 and add current value
            result = result * 26 + value;
        }

        return result;
    }
}
