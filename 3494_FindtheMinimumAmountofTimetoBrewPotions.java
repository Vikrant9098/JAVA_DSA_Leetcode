class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;  // n = number of wizards, m = number of potions
        long[] done = new long[n + 1];          // done[i] = time when wizard i finishes the current potion
        
        for (int j = 0; j < m; ++j) {           // loop through each potion
            for (int i = 0; i < n; ++i) {       // loop through each wizard
                // wizard i works on potion j after both he and previous wizard are ready
                done[i + 1] = Math.max(done[i + 1], done[i]) + (long) mana[j] * skill[i];
            }
            
            // adjust overlapping timings for next potion processing
            for (int i = n - 1; i > 0; --i) {
                // rollback intermediate overlap for next potion
                done[i] = done[i + 1] - (long) mana[j] * skill[i];
            }
        }
        
        return done[n];                         // final time when last wizard finishes last potion
    }
}
