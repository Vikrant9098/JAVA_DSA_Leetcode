import java.util.*; // import utilities for List and ArrayList

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>(); // store all palindrome partitions
        backtrack(s, 0, new ArrayList<>(), result); // start backtracking from index 0
        return result; // return all valid partitions
    }

    // backtracking function to generate all partitions
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) { // if reached end of string
            result.add(new ArrayList<>(current)); // add current partition to result
            return; // go back to try other partitions
        }

        for (int end = start; end < s.length(); end++) { // try every possible end index
            if (isPalindrome(s, start, end)) { // check if substring is palindrome
                current.add(s.substring(start, end + 1)); // add substring to current partition
                backtrack(s, end + 1, current, result); // move to next start index
                current.remove(current.size() - 1); // remove last substring (backtrack)
            }
        }
    }

    // helper function to check if substring s[left..right] is palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) { // compare characters from both ends
            if (s.charAt(left) != s.charAt(right)) return false; // not palindrome
            left++; // move left pointer right
            right--; // move right pointer left
        }
        return true; // substring is palindrome
    }
}
