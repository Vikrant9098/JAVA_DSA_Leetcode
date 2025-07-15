class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0; // Starting altitude
        int maxAltitude = 0; // To keep track of the highest altitude

        // Iterate through the gain array
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i]; // Update current altitude
            maxAltitude = Math.max(maxAltitude, currentAltitude); // Update max altitude if current is higher
        }

        return maxAltitude; // Return the highest altitude
    }
}
