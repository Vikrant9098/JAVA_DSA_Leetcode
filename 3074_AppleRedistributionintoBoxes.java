class Solution {

    // Function to find the minimum number of boxes needed
    public int minimumBoxes(int[] apple, int[] cap) {

        // Calculate total number of apples
        int sum = Arrays.stream(apple).sum();

        // Frequency array to count how many boxes of each capacity exist (0–50)
        int[] fq = new int[51];

        // Track the maximum and minimum box capacity
        int high = 0, low = 51;

        // Loop through each box capacity
        for (int c : cap) {
            fq[c]++;                 // Count this capacity
            high = Math.max(high, c); // Update highest capacity
            low = Math.min(low, c);   // Update lowest capacity
        }

        // Result: number of boxes used
        int res = 0;

        // Try using boxes starting from the largest capacity
        for (int i = high; i >= low && sum > 0; i--) {

            // Use all boxes of capacity i while apples remain
            while (fq[i]-- > 0 && sum > 0) {
                sum -= i;   // Put apples into this box
                res++;      // One more box used
            }
        }

        // Return minimum number of boxes required
        return res;
    }
}
