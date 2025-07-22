import java.util.HashSet;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        // A HashSet to keep track of unique elements in the current window
        HashSet<Integer> seen = new HashSet<>();

        // Left pointer for the sliding window
        int start = 0;

        // Sum of the current window's elements
        int currentSum = 0;

        // Variable to store the maximum sum of any valid subarray
        int maxSum = 0;

        // Iterate over the array using 'end' as the right boundary of the window
        for (int end = 0; end < nums.length; end++) {

            // If nums[end] is a duplicate (already in the set)
            // shrink the window from the left until it's removed
            while (seen.contains(nums[end])) {
                seen.remove(nums[start]);           // Remove element at start from the set
                currentSum -= nums[start];          // Subtract it from the current sum
                start++;                            // Move the start pointer forward
            }

            // Add the current element to the set and update the sum
            seen.add(nums[end]);
            currentSum += nums[end];

            // Update the maximum sum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum sum found
        return maxSum;
    }
}
