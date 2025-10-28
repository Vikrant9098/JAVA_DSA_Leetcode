import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();       // to store unique 10-letter sequences
        Set<String> repeated = new HashSet<>();   // to store repeated sequences
        int n = s.length();

        for (int i = 0; i + 9 < n; i++) {         // slide window of size 10
            String sub = s.substring(i, i + 10);  // get 10-letter substring
            if (!seen.add(sub)) {                 // if already seen before
                repeated.add(sub);                // add to repeated set
            }
        }

        return new ArrayList<>(repeated);         // convert set to list and return
    }
}
