class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        // totalDrunk keeps track of how many bottles we have drunk
        int totalDrunk = 0;

        // empty keeps track of how many empty bottles we have after drinking
        int empty = 0;

        // While we still have full bottles to drink
        while (numBottles > 0) {
            // Drink all full bottles available
            totalDrunk += numBottles;

            // Add those empty bottles to the empty count
            empty += numBottles;

            // Now all full bottles are drunk, so set numBottles = 0
            numBottles = 0;

            // If we have enough empty bottles to exchange for a new one
            if (empty >= numExchange) {
                // Exchange numExchange empty bottles for 1 new full bottle
                empty -= numExchange;

                // We now have 1 new full bottle to drink
                numBottles = 1;

                // After this exchange, the requirement increases by 1
                numExchange++;
            }
        }

        // Return total number of bottles drunk
        return totalDrunk;
    }
}
