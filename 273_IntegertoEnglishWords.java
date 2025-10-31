class Solution {
    // Arrays to map numbers to words
    private final String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                                      "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";     // Base case for 0

        int i = 0;                       // Index for thousand, million, billion
        String words = "";

        while (num > 0) {                // Process each 3-digit chunk
            if (num % 1000 != 0) {       // Only process if chunk is non-zero
                words = helper(num % 1000) + thousands[i] + (words.isEmpty() ? "" : " " + words);
            }
            num /= 1000;                 // Move to next 3 digits
            i++;                         // Move to next scale (Thousand, Million, etc.)
        }

        return words.trim();             // Remove any extra spaces
    }

    // Helper function to convert numbers below 1000 into words
    private String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return below20[num] + " ";                     // Numbers below 20
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10); // Tens and ones
        else return below20[num / 100] + " Hundred " + helper(num % 100);   // Hundreds
    }
}
