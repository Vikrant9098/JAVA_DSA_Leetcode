public class Solution {
    // Solution class

    public int bestClosingTime(String customers) {
        // Function to find the best hour to close the shop

        int max_score = 0, score = 0, best_hour = -1;
        // max_score = highest score seen so far
        // score = current score
        // best_hour = best index to close (initialized to -1)

        for(int i = 0; i < customers.length(); ++i) {
            // Loop through each hour

            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            // Add +1 if customer comes, else subtract 1

            if(score > max_score) {
                // If current score is better than before
                max_score = score;
                // Update maximum score
                best_hour = i;
                // Update best hour index
            }
        }

        return best_hour + 1;
        // Return closing hour (index + 1)
    }
}
