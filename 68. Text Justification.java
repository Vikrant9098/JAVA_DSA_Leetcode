import java.util.*; // Import utility package for List and ArrayList

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // Stores final justified lines
        int index = 0; // Pointer to track current word

        // Process words until all are placed in lines
        while (index < words.length) {
            int totalChars = words[index].length(); // Count chars in first word
            int last = index + 1; // Index of next word to try adding

            // Try to add as many words as possible to the current line
            while (last < words.length) {
                // Check if adding next word + 1 space exceeds maxWidth
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length(); // Add word + space
                last++; // Move to next word
            }

            StringBuilder sb = new StringBuilder(); // Build current line
            int gaps = last - index - 1; // Number of spaces (gaps) between words

            // Case 1: Last line OR only one word -> left justify
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]); // Add word
                    if (i != last - 1) sb.append(" "); // Add space if not last word
                }
                // Fill remaining spaces on the right
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Case 2: Fully justify (distribute spaces evenly)
                int spaces = (maxWidth - totalChars) / gaps; // Even spaces
                int extra = (maxWidth - totalChars) % gaps; // Extra spaces to distribute from left

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]); // Add word
                    sb.append(" "); // Add base space
                    for (int s = 0; s < spaces; s++) sb.append(" "); // Add even spaces
                    if (extra > 0) { // If extra spaces left
                        sb.append(" "); // Add one more
                        extra--; // Decrease extra space count
                    }
                }
                sb.append(words[last - 1]); // Add last word (no space after)
            }

            result.add(sb.toString()); // Add finished line to result
            index = last; // Move index to start of next line
        }

        return result; // Return all justified lines
    }
}
