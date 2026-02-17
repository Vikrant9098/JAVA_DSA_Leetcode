import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int k){
        // If no LEDs are on, only possible time is 0:00
        if (k == 0) return List.of("0:00");

        // Mask to get last 6 bits (for minutes)
        int mask = (1 << 6) - 1;

        // Smallest number with k bits set to 1
        int q = (1 << k) - 1;

        // Largest k-bit combination within 10 bits
        int limit = q << (10 - k);

        // List to store valid time strings
        List<String> res = new ArrayList<>();

        // Loop through all combinations of k bits
        while (q <= limit) {

            // Get last 6 bits → minutes
            int min = q & mask;

            // Get first 4 bits → hours
            int hour = q >> 6;

            // Check if valid hour and minute
            if (hour < 12 && min < 60)

                // Add formatted time (add leading 0 for minutes if needed)
                res.add(hour + ":" + (min < 10 ? "0" : "") + min);

            // Get rightmost set bit
            int r = q & -q;

            // Add rightmost set bit to q
            int n = q + r;

            // Generate next combination with same number of 1 bits
            q = (((q ^ n) / r) >> 2) | n;
        }

        // Return all valid times
        return res;
    }
}
