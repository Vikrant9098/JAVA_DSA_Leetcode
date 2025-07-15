class Solution {
    public boolean isValid(String word) {
        // Check if word has at least 3 characters
        if (word.length() < 3) return false;
        
        // Define vowels string for easy checking
        String vowels = "aeiouAEIOU";
        
        boolean hasVowel = false;
        boolean hasConsonant = false;
        
        // Check each character in the word
        for (char c : word.toCharArray()) {
            // Check if character is valid (only letters and digits allowed)
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            
            // Check if character is a letter (not a digit)
            if (Character.isLetter(c)) {
                // Check if it's a vowel or consonant
                if (vowels.indexOf(c) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        
        // Word is valid if it has at least one vowel and one consonant
        return hasVowel && hasConsonant;
    }
}

/**
 * System.out.println(new Solution().isValid("234Adas")); // true
 * System.out.println(new Solution().isValid("b3")); // false
 * System.out.println(new Solution().isValid("a3$e")); // false
 */