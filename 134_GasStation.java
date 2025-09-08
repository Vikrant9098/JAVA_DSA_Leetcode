class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;      // Sum of gas available at all stations
        int totalCost = 0;     // Sum of gas required to travel between stations
        int tank = 0;          // Current gas in the tank while traversing
        int start = 0;         // Candidate starting station index

        // Loop through all gas stations
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];        // Add gas at station i to totalGas
            totalCost += cost[i];      // Add cost to travel to next station to totalCost

            tank += gas[i] - cost[i];  // Update current tank after visiting station i

            // If tank becomes negative, cannot start from previous candidate
            if (tank < 0) {
                start = i + 1;  // Set next station as new starting candidate
                tank = 0;       // Reset tank to 0 for next candidate
            }
        }

        // If total gas >= total cost, the journey is possible, return starting index
        // Otherwise, return -1 (cannot complete the circuit)
        return totalGas >= totalCost ? start : -1;
    }
}
