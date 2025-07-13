class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Create two separate threads to sort both arrays concurrently
        // This can potentially improve performance by utilizing multiple CPU cores
        Thread t1 = new Thread(() -> Arrays.sort(players));  // Thread to sort players array
        Thread t2 = new Thread(() -> Arrays.sort(trainers)); // Thread to sort trainers array
        
        // Start both sorting threads simultaneously
        t1.start();
        t2.start();
        
        // Wait for both threads to complete their sorting operations
        try {
            t1.join();  // Wait for players array sorting to complete
            t2.join();  // Wait for trainers array sorting to complete
        } catch (Exception e) {
            // Handle any interruption exceptions (though unlikely in this context)
        }
        
        // Initialize variables for the matching process
        int cnt = 0;  // Counter for successful matchings
        int i = 0;    // Pointer for players array
        int j = 0;    // Pointer for trainers array
        
        // Two-pointer approach to find maximum matchings
        while (i < players.length && j < trainers.length) {
            // Check if current player can be matched with current trainer
            if (players[i] <= trainers[j]) {
                // Match found! Player i can be trained by trainer j
                cnt++;  // Increment successful matchings counter
                i++;    // Move to next player since current one is matched
            }
            // Always move to next trainer regardless of match or no match
            // If match: trainer j is now assigned, move to next trainer
            // If no match: trainer j capacity is too low, try next trainer
            j++;
        }
        
        // Return total number of successful matchings
        return cnt;
    }
}