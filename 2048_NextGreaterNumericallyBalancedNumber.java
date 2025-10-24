class Solution {
    public int nextBeautifulNumber(int n) {
        // Loop through all numbers greater than n up to 1224444
        // (1224444 is the largest possible numerically balanced number)
        for (int i = n + 1; i <= 1224444; i++) {
            
            // Check if the current number i is numerically balanced
            if (isBalanced(i)) 
                // If yes, return it as the answer
                return i;
        }

        // Return -1 if no such number is found (this line normally won't run)
        return -1;
    }

    // Helper function to check if a number is numerically balanced
    private boolean isBalanced(int num) {
        // Array to store count of each digit (0-9)
        int[] count = new int[10];

        // Convert the number to string and count each digit
        for (char c : String.valueOf(num).toCharArray()) {
            // Increase the count for the current digit
            count[c - '0']++;
        }

        // Check each digit from 0 to 9
        for (int i = 0; i < 10; i++) {
            // If the digit appears but not exactly 'i' times, return false
            if (count[i] != 0 && count[i] != i) 
                return false;
        }

        // If all digits follow the balanced condition, return true
        return true;
    }
}
