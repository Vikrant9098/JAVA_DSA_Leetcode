class Solution {
    public int findClosest(int x, int y, int z) {
        // Calculate distance of Person 1 from Person 3
        int dist1 = Math.abs(x - z);
        
        // Calculate distance of Person 2 from Person 3
        int dist2 = Math.abs(y - z);
        
        // Compare the distances
        if (dist1 < dist2) {
            return 1; // Person 1 reaches first
        } else if (dist2 < dist1) {
            return 2; // Person 2 reaches first
        } else {
            return 0; // Both reach at the same time
        }
    }
}
