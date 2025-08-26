class Solution 
{
    public int maxProfit(int[] prices) 
    {
        // Variable to store the minimum price found so far
        int minPrice = Integer.MAX_VALUE;

        // Variable to store the maximum profit
        int maxProfit = 0;

        // Traverse through the price array
        for (int price : prices) 
        {
            // Update the minimum price if a lower price is found
            if (price < minPrice) 
            {
                minPrice = price;
            }
            
            // Calculate the profit if selling at the current price
            int profit = price - minPrice;

            // Update maxProfit if the new profit is greater
            if (profit > maxProfit) 
            {
                maxProfit = profit;
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }
}
