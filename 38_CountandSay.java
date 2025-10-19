class Solution {
    public String countAndSay(int n) {
        // Base case: first term is always "1"
        if (n == 1) return "1";

        // Start from "1"
        String result = "1";

        // Generate sequence up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder(); // to build next sequence
            int count = 1;                          // count of same digits
            char prev = result.charAt(0);           // first character of current sequence

            // Loop through current sequence starting from second character
            for (int j = 1; j < result.length(); j++) {
                char curr = result.charAt(j);       // current character
                if (curr == prev) {                 // if same as previous
                    count++;                        // increase count
                } else {                            // if different
                    sb.append(count);               // add count to result
                    sb.append(prev);                // add previous digit
                    prev = curr;                    // move to new digit
                    count = 1;                      // reset count
                }
            }

            // Add the last group (count and digit)
            sb.append(count);
            sb.append(prev);

            // Update result with the newly built string
            result = sb.toString();
        }

        // Return the final sequence
        return result;
    }
}
