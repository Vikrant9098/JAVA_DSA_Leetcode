import java.util.*; // Import utility package for Arrays class

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // Sort the array so numbers are in increasing order
        Arrays.sort(nums);

        // 'last' stores the last distinct number we used
        long last = Long.MIN_VALUE;

        // 'count' will count how many distinct numbers we can make
        int count = 0;

        // Loop through each number in the sorted array
        for (int num : nums) {

            // Minimum value we can make from this number
            long low = num - k;

            // Maximum value we can make from this number
            long high = num + k;

            // Choose the smallest possible number greater than 'last'
            long newVal = Math.max(low, last + 1);

            // Check if the chosen number is still within allowed range
            if (newVal <= high) {

                // Increase distinct count
                count++;

                // Update 'last' with the new distinct number
                last = newVal;
            }
        }

        // Return the total count of distinct numbers
        return count;
    }
}
