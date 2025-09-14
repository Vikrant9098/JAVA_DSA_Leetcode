import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Create a set for exact matches (case-sensitive check)
        Set<String> exactSet = new HashSet<>(Arrays.asList(wordlist));

        // 2. Create a map for case-insensitive matches
        // Key = lowercase version, Value = first occurrence from wordlist
        Map<String, String> caseMap = new HashMap<>();
        for (String word : wordlist) {
            caseMap.putIfAbsent(word.toLowerCase(), word); // store only first match
        }

        // 3. Create a map for vowel-error matches
        // Key = word with vowels replaced by '*', Value = first occurrence from wordlist
        Map<String, String> vowelMap = new HashMap<>();
        for (String word : wordlist) {
            vowelMap.putIfAbsent(mask(word), word); // store only first match
        }

        // 4. Prepare result array to store answers for each query
        String[] result = new String[queries.length];

        // 5. Process each query
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i]; // current query word

            // Case 1: Exact match (case-sensitive)
            if (exactSet.contains(q)) {
                result[i] = q;
            }
            // Case 2: Case-insensitive match
            else if (caseMap.containsKey(q.toLowerCase())) {
                result[i] = caseMap.get(q.toLowerCase());
            }
            // Case 3: Vowel-error match
            else if (vowelMap.containsKey(mask(q))) {
                result[i] = vowelMap.get(mask(q));
            }
            // Case 4: No match found
            else {
                result[i] = "";
            }
        }

        // 6. Return the final array of results
        return result;
    }

    // Helper function: replace all vowels ('a','e','i','o','u') with '*'
    private String mask(String word) {
        StringBuilder sb = new StringBuilder(); // to build masked word
        for (char c : word.toLowerCase().toCharArray()) { // convert to lowercase
            if ("aeiou".indexOf(c) >= 0) { // check if character is a vowel
                sb.append('*'); // replace vowel with '*'
            } else {
                sb.append(c); // keep consonant as it is
            }
        }
        return sb.toString(); // return masked string
    }
}
