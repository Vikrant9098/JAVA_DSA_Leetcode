class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Array to count frequency of each letter (26 lowercase letters)
        int[] count = new int[26];

        // Count letters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {  // If letter not available
                return false;          // Cannot construct ransomNote
            }
            count[c - 'a']--;          // Use one occurrence of the letter
        }

        return true;  // All letters found, ransomNote can be constructed
    }
}
