class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initialize the minimum and maximum possible eating speeds
        int low = 1; // minimum possible speed
        int high = getMax(piles); // maximum possible speed is the largest pile

        // Perform binary search to find the minimum valid eating speed
        while (low < high) {
            int mid = low + (high - low) / 2; // Calculate mid speed

            // Calculate total hours needed to eat all bananas at this speed
            int hours = getTotalHours(piles, mid);

            if (hours <= h) {
                // If Koko can eat all bananas in h or fewer hours, try a smaller speed
                high = mid;
            } else {
                // If not, she needs to eat faster
                low = mid + 1;
            }
        }

        // When low == high, we found the minimum possible speed
        return low;
    }

    // Helper method to find the maximum pile value
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }

    // Helper method to calculate total hours needed at given speed
    private int getTotalHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            // Use ceiling division: (pile + speed - 1) / speed
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}
