class Solution {
    public boolean checkOnesSegment(String s) {

        // This variable tracks whether we have already seen a '0'
        // Once a '0' appears, any later '1' would mean there are multiple segments of '1'
        boolean seenZero = false;

        // Convert the string to a character array and iterate through each character
        for(char c : s.toCharArray()) {

            // If current character is '0'
            if(c == '0') {
                // Mark that we have encountered a zero
                // After this point, we should not see any '1'
                seenZero = true;

            // If current character is '1' AND we already saw a zero earlier
            } else if(seenZero) {

                // This means the pattern is like "111011"
                // So there are multiple segments of '1'
                // Therefore return false
                return false;
            }
        }

        // If we completed the loop without finding a '1' after a '0',
        // then there is only one continuous segment of '1'
        return true;
    }
}