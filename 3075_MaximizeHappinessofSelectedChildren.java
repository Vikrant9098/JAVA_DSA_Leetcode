import java.util.Arrays;

public class Solution { 
    // Defines the Solution class

    public long maximumHappinessSum(int[] happiness, int k) {
        // Method that returns the maximum total happiness
        // happiness[] → array of happiness values
        // k → number of people/items to choose

        Arrays.sort(happiness);
        // Sort the happiness array in ascending order
        // This helps us pick the largest happiness values first from the end

        long res = 0;
        // Variable to store the final total happiness sum

        int n = happiness.length, j = 0;
        // n → total number of elements in the array
        // j → counts how many elements have already been chosen
        //      (used to reduce happiness each time)

        for (int i = n - 1; i >= n - k; --i) {
            // Loop through the largest k elements (from right to left)

            happiness[i] = Math.max(happiness[i] - j++, 0);
            // Reduce the current happiness by j
            // j increases after each selection
            // Math.max ensures happiness does not go below 0

            res += happiness[i];
            // Add the adjusted happiness value to the result
        }

        return res;
        // Return the maximum possible happiness sum
    }
}
