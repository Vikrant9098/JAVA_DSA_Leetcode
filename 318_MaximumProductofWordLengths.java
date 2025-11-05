class Solution {
    public int maxProduct(String[] words) {
        int n = words.length; // total number of words
        int[] masks = new int[n]; // to store bitmask of each word
        int[] lens = new int[n];  // to store length of each word

        // Step 1: Convert each word into a bitmask
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a'); // set bit for each character
            }
            masks[i] = mask; // store the bitmask
            lens[i] = words[i].length(); // store word length
        }

        int max = 0; // to store maximum product

        // Step 2: Compare every pair of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // if two words have no common letters
                if ((masks[i] & masks[j]) == 0) {
                    // calculate product of lengths
                    int product = lens[i] * lens[j];
                    // update max if greater
                    max = Math.max(max, product);
                }
            }
        }

        return max; // return final maximum product
    }
}
