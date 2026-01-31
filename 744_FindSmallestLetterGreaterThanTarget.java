class Solution {                       // Defines the Solution class

    public char nextGreatestLetter(char[] letters, char target) {
        // Method to find the smallest letter greater than target

        char res = letters[0];          // Initialize result with first letter (default wrap-around case)
        boolean flag = false;           // Flag to check if a greater letter is found

        for (char ch : letters) {       // Loop through each character in letters array

            if (!flag) {                // If no greater letter found yet
                if (ch > target) {      // Check if current letter is greater than target
                    res = ch;           // Store current letter as result
                    flag = !flag;       // Mark that we found a greater letter
                }
            } else {                    // If a greater letter is already found
                if (ch > target && ch < res)
                    res = ch;           // Update result with smaller valid greater letter
            }
        }

        return res;                     // Return the final answer
    }
}
