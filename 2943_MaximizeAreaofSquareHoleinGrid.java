import java.util.Arrays;

class Solution { 
    // Main class that contains the solution

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Method to calculate the maximum square hole area

        Arrays.sort(hBars);
        // Sort horizontal bars to find consecutive gaps

        Arrays.sort(vBars);
        // Sort vertical bars to find consecutive gaps

        int s = Math.min(maxSpan(hBars), maxSpan(vBars));
        // Find the smallest maximum span between horizontal and vertical bars

        return s * s;
        // Return the area of the square (side × side)
    }

    private int maxSpan(int[] bars) {
        // Helper method to find maximum consecutive span

        int res = 1, streak = 1;
        // res stores max span, streak counts current consecutive bars

        for (int i = 1; i < bars.length; i++) {
            // Loop through the bars array

            if (bars[i] - bars[i - 1] == 1)
                // Check if current bar is consecutive to previous

                streak++;
                // Increase current streak if consecutive
            else
                streak = 1;
                // Reset streak if not consecutive

            res = Math.max(res, streak);
            // Update maximum span found so far
        }

        return ++res;
        // Add 1 to include grid edge and return final span
    }
}
