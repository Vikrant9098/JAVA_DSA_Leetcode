class Solution {
    public boolean doesAliceWin(String s) {
        // Define a string containing all vowels
        String vowels = "aeiou";
        
        // Variable to store the count of vowels in the input string
        int vowelCount = 0;
        
        // Loop through each character in the string 's'
        for (char ch : s.toCharArray()) {
            // Check if the character is a vowel
            if (vowels.indexOf(ch) != -1) {
                // Increment the vowel count if it is a vowel
                vowelCount++;
            }
        }
        
        // If there are no vowels, Alice cannot make a move on her first turn → she loses
        if (vowelCount == 0) {
            return false;
        }
        
        // If there is at least one vowel, Alice can always make a move and eventually win
        return true;
    }
}
