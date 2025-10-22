import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) { // Function to return all valid IPs
        List<String> result = new ArrayList<>(); // List to store valid IP addresses
        backtrack(s, 0, new ArrayList<>(), result); // Start backtracking from index 0
        return result; // Return final list
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        if (path.size() == 4) { // If we already have 4 parts
            if (index == s.length()) // And used all characters
                result.add(String.join(".", path)); // Join with dots and add to result
            return; // Stop recursion
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) { // Try parts of length 1–3
            String part = s.substring(index, index + len); // Get substring
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255) // Invalid part
                continue; // Skip invalid
            path.add(part); // Choose current part
            backtrack(s, index + len, path, result); // Recurse for next part
            path.remove(path.size() - 1); // Backtrack (remove last part)
        }
    }
}
