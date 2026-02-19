class Solution {
    public int countBinarySubstrings(String s) {
        int curr = 1, prev = 0, ans = 0; 
        // curr = length of current group of same characters
        // prev = length of previous group
        // ans = total valid binary substrings count

        for (int i = 1; i < s.length(); i++) 
            // Start from index 1 and compare with previous character

            if (s.charAt(i) == s.charAt(i-1)) 
                curr++;  
                // If same as previous character, increase current group length

            else {
                ans += Math.min(curr, prev); 
                // Add minimum of current and previous group to answer
                // (valid substrings are limited by smaller group)

                prev = curr; 
                // Current group becomes previous group

                curr = 1; 
                // Start new group with count 1
            }

        return ans + Math.min(curr, prev); 
        // Add last group's contribution and return result
    }
}
