/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // Initialize the search boundaries
        int low = 1;
        int high = n;
        
        // Perform binary search
        while (low <= high) {
            // Avoid potential overflow
            int mid = low + (high - low) / 2;
            
            // Use the guess API to get feedback
            int res = guess(mid);
            
            // If guess is correct, return the number
            if (res == 0) {
                return mid;
            }
            // If guess is higher than pick, search in the left half
            else if (res == -1) {
                high = mid - 1;
            }
            // If guess is lower than pick, search in the right half
            else {
                low = mid + 1;
            }
        }
        
        // This return will never be hit due to problem constraints
        return -1;
    }
}
