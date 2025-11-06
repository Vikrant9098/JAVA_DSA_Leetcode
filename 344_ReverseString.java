class Solution {
    public void reverseString(char[] s) {
        int left = 0;               // start pointer
        int right = s.length - 1;   // end pointer

        // swap characters until both pointers meet
        while (left < right) {
            char temp = s[left];    // store left char
            s[left] = s[right];     // put right char in left
            s[right] = temp;        // put temp in right
            left++;                 // move left forward
            right--;                // move right backward
        }
    }
}
