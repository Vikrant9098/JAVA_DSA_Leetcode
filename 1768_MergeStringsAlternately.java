import java.util.*;
class Solution {
    public static String mergeAlternately(String word1, String word2) {
        // Create StringBuilder for efficient string concatenation
        StringBuilder merged=new StringBuilder();
        // Initialize index counter and store lengths of both strings
        int i=0,len1=word1.length(),len2=word2.length();
        
        // Loop while both strings have characters at current index
        while(i<len1 && i<len2)
        {
            // Add character from word1 at current index
            merged.append(word1.charAt(i));
            // Add character from word2 at current index
            merged.append(word2.charAt(i));
            // Move to next index
            i++;
        }
        
        // Check if word1 has remaining characters
        if (i < len1) {
            // Add all remaining characters from word1 using substring
            merged.append(word1.substring(i));
        }
        
        // Check if word2 has remaining characters
        if (i < len2) {
            // Add all remaining characters from word2 using substring
            merged.append(word2.substring(i));
        }

        // Convert StringBuilder to String and return
        return merged.toString();
    }

    // Main method to test the solution
    public static void main(String[]args)
    {
        // Create Scanner object to read input from console
        Scanner sc=new Scanner(System.in);
        // Read first string from user input
        String word1=sc.nextLine();
        // Read second string from user input
        String word2=sc.nextLine();
        // Call mergeAlternately method and store result
        String result = mergeAlternately(word1, word2);
        // Print the merged result
        System.out.println(result);
    }
}