class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        // If lengths differ, t cannot be an anagram of s
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];  // Array to store frequency of each letter (a-z)

        // Count letters in s and subtract letters in t
        for(int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;  // Increment count for char in s
            freq[t.charAt(i) - 'a']--;  // Decrement count for char in t
        }

        // Check if all counts are zero
        for(int count : freq)
        {
            if(count != 0) return false;  // If any count not zero → not an anagram
        }

        return true;  // All counts zero → valid anagram
    }
}
