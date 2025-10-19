import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        // Queue for BFS to explore all possible strings
        Queue<String> queue = new LinkedList<>();
        // Set to store visited strings to avoid repetition
        Set<String> visited = new HashSet<>();
        
        // Add initial string to queue and mark as visited
        queue.offer(s);
        visited.add(s);
        
        // Initialize answer as the given string
        String smallest = s;
        
        // BFS traversal
        while (!queue.isEmpty()) {
            // Get current string
            String curr = queue.poll();
            // Update smallest if we find lexicographically smaller string
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            
            // ----- Operation 1: Add 'a' to all odd indices -----
            char[] chars = curr.toCharArray();  // Convert string to char array
            for (int i = 1; i < chars.length; i += 2) {  // Loop through odd indices
                int newDigit = (chars[i] - '0' + a) % 10; // Add 'a' and wrap around 10
                chars[i] = (char) (newDigit + '0');       // Convert back to character
            }
            String added = new String(chars);  // Create new string after addition
            
            // If new string not visited, add to queue
            if (visited.add(added)) {
                queue.offer(added);
            }
            
            // ----- Operation 2: Rotate string to the right by 'b' -----
            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            
            // If new string not visited, add to queue
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }
        
        // Return the smallest string found
        return smallest;
    }
}
