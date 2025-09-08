import java.util.Arrays;  
// Import Arrays utility class to use the sort() method

class Solution {
    public int hIndex(int[] citations) {
        // Sort the array of citations in ascending order
        Arrays.sort(citations);
        
        // Store the total number of papers
        int n = citations.length;

        // Initialize h-index value to 0
        int h = 0;

        // Traverse through the sorted array
        // i represents the current index in the sorted array
        for (int i = 0; i < n; i++) {
            // Calculate how many papers have at least citations[i] citations
            // Since the array is sorted, all papers from index i to n-1 
            // have citations >= citations[i]
            int papersWithAtLeast = n - i; 

            // Check if current citation count satisfies the h-index condition
            // i.e., citations[i] >= number of papers with at least that many citations
            if (citations[i] >= papersWithAtLeast) {
                // Update h-index value
                h = papersWithAtLeast;

                // Break since we found the maximum valid h-index
                break;
            }
        }

        // Return the final h-index
        return h;
    }
}
