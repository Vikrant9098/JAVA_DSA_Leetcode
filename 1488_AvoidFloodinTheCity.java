import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        
        // Map to track which lake is currently full and on which day it was last filled
        Map<Integer, Integer> fullLakes = new HashMap<>();
        
        // TreeSet to store indexes of dry days (rains[i] == 0)
        TreeSet<Integer> dryDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            
            // If it rains on this day
            if (lake > 0) {
                ans[i] = -1; // as per problem statement
                
                // If this lake is already full, we must find a dry day to empty it before this day
                if (fullLakes.containsKey(lake)) {
                    // Find a dry day (index) that occurs after the last time this lake was filled
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    
                    // If no such dry day exists, flood can't be avoided
                    if (dryDay == null) return new int[0];
                    
                    // Use that dry day to dry this lake
                    ans[dryDay] = lake;
                    
                    // Remove that dry day since it's used now
                    dryDays.remove(dryDay);
                }
                
                // Update the last filled day for this lake
                fullLakes.put(lake, i);
            } 
            else {
                // If no rain, mark this day as available to dry any lake
                dryDays.add(i);
                
                // Default value, can be replaced later when we assign a specific lake to dry
                ans[i] = 1;
            }
        }
        
        return ans;
    }
}
