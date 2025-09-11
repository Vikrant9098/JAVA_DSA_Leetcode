class Solution {
    public String sortVowels(String s) {
        // Step 1: Define vowels (both lowercase and uppercase) in a string
        String vowels = "aeiouAEIOU";
        
        // Step 2: Convert the input string into a character array (mutable, so we can update characters)
        char[] chars = s.toCharArray();
        
        // Step 3: Create a list to store all vowels from the input string
        java.util.List<Character> vowelList = new java.util.ArrayList<>();
        
        // Step 4: Traverse each character in the string
        for (char c : chars) {
            // If the character is a vowel (present in vowels string)
            if (vowels.indexOf(c) != -1) { 
                // Add the vowel to the list
                vowelList.add(c);
            }
        }
        
        // Step 5: Sort the collected vowels according to ASCII values
        java.util.Collections.sort(vowelList);
        
        // Step 6: Initialize an index to keep track of position in sorted vowels
        int idx = 0;
        
        // Step 7: Traverse the original character array
        for (int i = 0; i < chars.length; i++) {
            // If the current character is a vowel
            if (vowels.indexOf(chars[i]) != -1) {
                // Replace it with the next vowel from the sorted list
                chars[i] = vowelList.get(idx++);
            }
        }
        
        // Step 8: Convert the modified character array back to a string and return
        return new String(chars);
    }
}
