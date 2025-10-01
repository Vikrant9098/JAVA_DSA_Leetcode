public class 1518_WaterBottles {
    
}
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // total bottles you can drink
        int totalDrank = numBottles;
        
        // keep exchanging empty bottles until not possible
        while (numBottles >= numExchange) {
            // new full bottles you can get
            int newBottles = numBottles / numExchange;
            
            // update total drank
            totalDrank += newBottles;
            
            // remaining empty bottles + new empty bottles
            numBottles = (numBottles % numExchange) + newBottles;
        }
        
        return totalDrank;
    }
}
