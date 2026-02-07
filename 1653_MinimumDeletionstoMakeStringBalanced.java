class Solution {                      // Define the Solution class
    public int minimumDeletions(String s) {   // Method to find minimum deletions
        
        int res = 0, count = 0;        // res = total deletions needed
                                       // count = number of 'b' seen so far
        
        for (char c : s.toCharArray()) { // Loop through each character in the string
            
            if (c == 'b')               // If current character is 'b'
                count++;                // Increase count of 'b'
            
            else if (count != 0) {      // If character is 'a' and there are 'b's before it
                res++;                  // Delete this 'a' (increase deletions)
                count--;                // Use one previous 'b' to balance
            }
        }
        
        return res;                     // Return total minimum deletions
    }
}
