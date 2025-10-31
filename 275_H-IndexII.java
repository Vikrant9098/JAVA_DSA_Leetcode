class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length; // total number of papers
        int left = 0, right = n - 1; // binary search boundaries
        
        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // find middle index
            int h = n - mid; // number of papers with at least citations[mid] citations
            
            // If citations[mid] is enough for h-index
            if (citations[mid] == h) {
                return h; // exact match found
            } else if (citations[mid] < h) {
                left = mid + 1; // need more citations, move right
            } else {
                right = mid - 1; // too many citations, move left
            }
        }
        
        // When loop ends, h-index is n - left
        return n - left;
    }
}
