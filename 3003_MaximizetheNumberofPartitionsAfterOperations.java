class Solution {
    private HashMap<Long, Integer> cache; // to store computed results for memoization
    private String s; // the input string
    private int k; // allowed number of distinct characters

    public int maxPartitionsAfterOperations(String s, int k) {
        this.cache = new HashMap<>(); // initialize cache
        this.s = s; // assign string
        this.k = k; // assign k
        return dp(0, 0, true) + 1; // start from index 0, empty set, change allowed once, add 1 for first partition
    }

    private int dp(int index, int currentSet, boolean canChange) {
        // create a unique key for current state using index, set, and change flag
        long key = ((long) index << 27)
                | ((long) currentSet << 1)
                | (canChange ? 1 : 0);

        // if already computed, return cached value
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // base case: reached end of string
        if (index == s.length()) {
            return 0;
        }

        int characterIndex = s.charAt(index) - 'a'; // get numeric index of current char
        int currentSetUpdated = currentSet | (1 << characterIndex); // add this char to current set
        int distinctCount = Integer.bitCount(currentSetUpdated); // count distinct characters in set

        int res; // result for this state

        // if distinct chars exceed k, start new partition
        if (distinctCount > k) {
            res = 1 + dp(index + 1, 1 << characterIndex, canChange);
        } else { 
            // else continue current partition
            res = dp(index + 1, currentSetUpdated, canChange);
        }

        // if we can still change one character
        if (canChange) {
            // try changing current character to all 26 possible letters
            for (int newCharIndex = 0; newCharIndex < 26; newCharIndex++) {
                int newSet = currentSet | (1 << newCharIndex); // add new char to set
                int newDistinctCount = Integer.bitCount(newSet); // count new distinct chars

                // if distinct > k, new partition needed
                if (newDistinctCount > k) {
                    res = Math.max(res, 1 + dp(index + 1, 1 << newCharIndex, false));
                } else {
                    // else continue same partition
                    res = Math.max(res, dp(index + 1, newSet, false));
                }
            }
        }

        cache.put(key, res); // store result in cache
        return res; // return final result for this state
    }
}
