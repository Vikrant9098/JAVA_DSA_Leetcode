class Solution {

    public int longestBalanced(String s) {

        // Convert string into char array for easy access
        char[] c = s.toCharArray();

        // Length of the string
        int n = c.length;

        // Current consecutive counts of a, b, c
        int cur_a = 0, cur_b = 0, cur_c = 0;

        // Maximum consecutive counts of a, b, c
        int max_a = 0, max_b = 0, max_c = 0;

        // Traverse through the character array
        for (int i = 0; i < n; i++) {

            // If current character is 'a'
            if (c[i] == 'a') {

                // If previous char is also 'a', increase count, else start from 1
                cur_a = (i > 0 && c[i-1] == 'a') ? cur_a + 1 : 1;

                // Update maximum consecutive 'a'
                max_a = Math.max(max_a, cur_a);

            } 
            // If current character is 'b'
            else if (c[i] == 'b') {

                // Same logic for 'b'
                cur_b = (i > 0 && c[i-1] == 'b') ? cur_b + 1 : 1;

                // Update maximum consecutive 'b'
                max_b = Math.max(max_b, cur_b);

            } 
            // Otherwise it must be 'c'
            else {

                // Same logic for 'c'
                cur_c = (i > 0 && c[i-1] == 'c') ? cur_c + 1 : 1;

                // Update maximum consecutive 'c'
                max_c = Math.max(max_c, cur_c);
            }
        }

        // Start result with maximum single character streak
        int res = Math.max(Math.max(max_a, max_b), max_c);

        // Check longest balanced substring between pairs
        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        // Check longest balanced substring among all three characters
        res = Math.max(res, find3(c));

        // Return final maximum length
        return res;
    }

    // Function to find longest balanced substring between 2 characters
    private int find2(char[] c, char x, char y) {

        int n = c.length, max_len = 0;

        // Array to store first occurrence of diff value
        int[] first = new int[2 * n + 1];

        // Fill with -2 to mark unvisited
        Arrays.fill(first, -2);

        // Index where invalid character occurred
        int clear_idx = -1;

        // Start diff from middle (to avoid negative index)
        int diff = n;

        // Base case: diff seen at index -1
        first[diff] = -1;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // If current char is not x or y
            if (c[i] != x && c[i] != y) {

                // Reset window
                clear_idx = i;

                // Reset diff
                diff = n;

                // Mark this diff position
                first[diff] = clear_idx;

            } else {

                // Increase diff if x
                if (c[i] == x) diff++;
                // Decrease diff if y
                else diff--;

                // If first time seeing this diff after last invalid char
                if (first[diff] < clear_idx) {

                    // Store index
                    first[diff] = i;

                } else {

                    // Balanced substring found
                    max_len = Math.max(max_len, i - first[diff]);
                }
            }
        }

        // Return max length found
        return max_len;
    }

    // Function to find longest balanced substring among a, b, c
    private int find3(char[] c) {

        // Unique starting state value
        long state = Long.MAX_VALUE / 2;

        // Map to store first occurrence of state
        Map<Long, Integer> first = new HashMap<>();

        // Base state seen at index -1
        first.put(state, -1);

        // Maximum length result
        int max_len = 0;

        // Traverse array
        for (int i = 0; i < c.length; i++) {

            // Update state uniquely for each character
            if (c[i] == 'a') state += 1_000_001;
            else if (c[i] == 'b') state -= 1_000_000;
            else state--;

            // If this state already seen
            if (first.containsKey(state)) {

                // Balanced substring found
                max_len = Math.max(max_len, i - first.get(state));

            } else {

                // Store first occurrence of this state
                first.put(state, i);
            }
        }

        // Return maximum length found
        return max_len;
    }
}
