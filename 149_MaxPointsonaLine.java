import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n; // 0, 1, or 2 points always lie on the same line
        
        int maxPoints = 0; // store the overall maximum points
        
        // Loop through each point as the reference point
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>(); // map to count points with same slope
            int duplicates = 0; // count points identical to points[i]
            int currMax = 0; // max points on a line with points[i] as reference
            
            // Compare reference point with every other point
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0]; // x difference
                int dy = points[j][1] - points[i][1]; // y difference
                
                if (dx == 0 && dy == 0) {
                    duplicates++; // same point, increase duplicates
                    continue;
                }
                
                // Reduce slope to simplest fraction
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                // Create a string key for the slope
                String slope = dx + "/" + dy;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1); // count points with this slope
                
                currMax = Math.max(currMax, slopeCount.get(slope)); // update current max for this reference point
            }
            
            // Add duplicates and reference point itself
            maxPoints = Math.max(maxPoints, currMax + duplicates + 1);
        }
        
        return maxPoints; // return the overall maximum points on a line
    }
    
    // Helper method to compute GCD
    private int gcd(int a, int b) {
        if (b == 0) return a; // base case
        return gcd(b, a % b); // recursive GCD
    }
}
