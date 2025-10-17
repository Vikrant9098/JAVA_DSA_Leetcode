import java.util.*; // import utility classes like List and Arrays

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(); // list to store starting indices of anagrams
        if (s.length() < p.length()) return res; // if s is smaller than p, no anagram possible

        int[] pCount = new int[26]; // count of each letter in p
        int[] sCount = new int[26]; // count of each letter in current window of s

        // count frequency of each character in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++; // increase count for that letter
        }

        int window = p.length(); // window size equal to length of p

        // loop through all characters in s
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++; // add current character to window count

            // if window size exceeds p length
            if (i >= window) {
                sCount[s.charAt(i - window) - 'a']--; // remove leftmost character from window
            }

            // if both frequency arrays match, it's an anagram
            if (Arrays.equals(pCount, sCount)) {
                res.add(i - window + 1); // add starting index of the anagram
            }
        }

        return res; // return all starting indices
    }
}
