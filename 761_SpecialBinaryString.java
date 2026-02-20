import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        int cnt = 0;  
        // Counter to track balance of '1's and '0's

        List<String> list = new LinkedList<>();  
        // List to store special substrings

        int j = 0;  
        // Start index of current special substring

        for (int i = 0; i < s.length(); i++) {
            // Loop through each character of the string

            if (s.charAt(i) == '1')
                cnt++;  
            // Increase count for '1'

            else 
                cnt--;  
            // Decrease count for '0'

            if (cnt == 0) {
                // When count becomes 0, we found a valid special substring

                list.add('1' + makeLargestSpecial(s.substring(j + 1, i)) + '0');  
                // Recursively process inner part and wrap with '1' and '0'

                j = i + 1;  
                // Move start index to next position
            }
        }

        Collections.sort(list, Collections.reverseOrder());  
        // Sort substrings in descending order to make result largest

        return String.join("", list);  
        // Join all substrings into final result string
    }
}