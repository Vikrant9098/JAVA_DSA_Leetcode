class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        // Loop until columnNumber becomes 0
        while (columnNumber > 0) {
            columnNumber--; // Adjust to make it 0-indexed (A=0, B=1, ..., Z=25)
            int remainder = columnNumber % 26; // Find remainder
            char letter = (char) ('A' + remainder); // Convert remainder to corresponding letter
            result.append(letter); // Add to result
            columnNumber /= 26; // Move to next position
        }

        // Reverse since we constructed from least significant to most
        return result.reverse().toString();
    }
}
