class Solution {
    public int maxFreqSum(String s) {
        // Define a string containing all vowels for easy lookup
        String vowels = "aeiou";

        // Create an array to store frequency of each letter (26 letters in English alphabet)
        int[] freq = new int[26];

        // Loop through each character in the input string
        for (char c : s.toCharArray()) {
            // Increment the frequency of the character (using index c - 'a')
            freq[c - 'a']++;
        }

        // Variable to store the maximum frequency among vowels
        int maxVowelFreq = 0;
        // Variable to store the maximum frequency among consonants
        int maxConsonantFreq = 0;

        // Loop through all 26 letters
        for (int i = 0; i < 26; i++) {
            // Convert index back to character
            char c = (char) (i + 'a');
            // Check if this character appeared in the string
            if (freq[i] > 0) {
                // If the character is a vowel
                if (vowels.indexOf(c) != -1) {
                    // Update maximum vowel frequency if this is higher
                    maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
                } else {
                    // Otherwise it's a consonant, update maximum consonant frequency
                    maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
                }
            }
        }

        // Return the sum of the maximum vowel frequency and maximum consonant frequency
        return maxVowelFreq + maxConsonantFreq;
    }
}
