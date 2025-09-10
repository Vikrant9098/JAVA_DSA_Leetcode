class Solution {
    public String convert(String s, int numRows) {
        // If only one row, no zigzag pattern
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;       // current row
        boolean down = true; // direction: down or up

        // Place each character in the correct row
        for (char c : s.toCharArray()) {
            rows[row].append(c);
            // If we reach top or bottom, change direction
            if (row == 0) {
                down = true;
            } else if (row == numRows - 1) {
                down = false;
            }
            // Move row pointer
            row += down ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}
