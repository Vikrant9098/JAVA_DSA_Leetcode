class Solution {
    public String getHint(String secret, String guess) {
        // to count bulls
        int bulls = 0;
        // array to track digits seen (0–9)
        int[] count = new int[10];
        // to count cows
        int cows = 0;
        
        // loop through each digit
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i); // current digit in secret
            char g = guess.charAt(i);  // current digit in guess
            
            // if both digits match → bull
            if (s == g) {
                bulls++;
            } else {
                int sNum = s - '0'; // convert secret char to number
                int gNum = g - '0'; // convert guess char to number
                
                // if guess digit was seen before in secret → cow
                if (count[sNum] < 0) cows++;
                
                // if secret digit was seen before in guess → cow
                if (count[gNum] > 0) cows++;
                
                // update counts for both digits
                count[sNum]++;
                count[gNum]--;
            }
        }
        
        // return result in "xAyB" format
        return bulls + "A" + cows + "B";
    }
}
