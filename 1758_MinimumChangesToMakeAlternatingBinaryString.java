class Solution {
    public int minOperations(String s) {
        // Take the first character of the string as the starting expected character
        char c_0 = s.charAt(0);

        // Count operations assuming the alternating pattern starts with the first character
        int count1 = count(s, c_0);

        // Count operations assuming the alternating pattern starts with the opposite character
        // +1 because the first character itself would need to be changed
        int count2 = count(s, c_0=='0'?'1':'0') + 1;

        // Return the minimum operations required among both possibilities
        return Math.min(count1, count2);
    }

    // Helper function to count how many changes are needed
    // to make the string alternating starting with character c_pre
    private int count(String s, char c_pre){
        int count = 0;  // Stores number of changes required

        // Start from index 1 because index 0 is already considered as starting character
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);  // Current character in the string

            // If current character is same as previous expected character,
            // then it breaks the alternating pattern
            if(current == c_pre){
                count++;  // We need to change this character

                // After changing, flip the expected character
                // Example: if previous was '0', next expected becomes '1'
                c_pre = c_pre == '0' ? '1' : '0';
            }else{
                // If characters are different, pattern is correct
                // So update previous expected character to current
                c_pre = current;   
            }
        }

        // Return total number of operations required
        return count;
    }
}