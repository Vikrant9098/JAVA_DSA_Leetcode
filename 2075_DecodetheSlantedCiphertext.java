class Solution {

    public String decodeCiphertext(String encodedText, int rows) {

        // If there is only 1 row, no diagonal decoding is needed
        if (rows == 1)
            return encodedText;

        // Total length of the encoded string
        int n = encodedText.length();

        // Number of columns in the matrix
        int cols = n / rows;

        // StringBuilder to store the decoded result
        StringBuilder res = new StringBuilder(n);

        // Traverse column by column (starting point of diagonals)
        for (int c = 0; c < cols; c++) {

            // Start from row = 0 and column = c
            int r = 0, j = c;

            // Move diagonally: (r++, j++)
            while (r < rows && j < cols) {

                // Convert 2D index (r, j) → 1D index: r * cols + j
                // Append that character to result
                res.append(encodedText.charAt(r * cols + j));

                // Move to next diagonal position
                r++;
                j++;
            }
        }

        // Remove trailing spaces from the decoded string
        int end = res.length() - 1;

        // Move backward while characters are spaces
        while (end >= 0 && res.charAt(end) == ' ') {
            end--;
        }

        // Return substring without trailing spaces
        return res.substring(0, end + 1);
    }
}