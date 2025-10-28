import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // convert list to set for fast lookup
        Map<String, List<String>> memo = new HashMap<>(); // store already computed results
        return backtrack(s, wordSet, memo);              // start recursive function
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s))                         // if result already computed
            return memo.get(s);                          // return from memo
        
        List<String> result = new ArrayList<>();          // list to store valid sentences

        if (s.isEmpty()) {                               // base case: if string is empty
            result.add("");                              // add empty string (end of path)
            return result;                               // return to build final sentence
        }

        // check each word in dictionary
        for (String word : wordSet) {
            if (s.startsWith(word)) {                    // if string starts with this word
                String rest = s.substring(word.length()); // remaining string after the word
                List<String> subSentences = backtrack(rest, wordSet, memo); // recurse for rest

                // combine current word with each possible continuation
                for (String sub : subSentences) {
                    String space = sub.isEmpty() ? "" : " "; // add space only if needed
                    result.add(word + space + sub);          // build and store the full sentence
                }
            }
        }

        memo.put(s, result);                             // save result for current substring
        return result;                                   // return all valid sentences
    }
}
