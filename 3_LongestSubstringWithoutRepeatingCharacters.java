import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current window
        HashSet<Character> set = new HashSet<>();
        
        // Two pointers: 'left' for start of window, 'right' for end
        int left = 0, maxLength = 0;

        // Iterate through the string using the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If duplicate character found in the set, move left pointer to shrink window
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // Remove left character from set
                left++; // Move left pointer ahead
            }

            // Add the new unique character to the set
            set.add(s.charAt(right));

            // Update maxLength if current window size is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the maximum length of the substring without repeating characters
        return maxLength;
    }

 
}
