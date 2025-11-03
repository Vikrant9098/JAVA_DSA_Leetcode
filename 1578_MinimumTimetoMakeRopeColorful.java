class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;  // total time to remove balloons
        int n = colors.length();

        // loop through balloons
        for (int i = 1; i < n; i++) {
            // if two adjacent balloons have same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // add the smaller time to total (remove that balloon)
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);

                // keep the larger time for next comparison
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTime;
    }
}
