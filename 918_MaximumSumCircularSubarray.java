class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // standard max subarray sum (Kadane's algorithm)
        int total = 0;          // sum of all elements
        int maxSum = nums[0];   // max subarray sum
        int currentMax = 0;     
        int minSum = nums[0];   // min subarray sum
        int currentMin = 0;
        
        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num); // extend or start new subarray
            maxSum = Math.max(maxSum, currentMax);       // update global max
            
            currentMin = Math.min(num, currentMin + num); // extend or start new min subarray
            minSum = Math.min(minSum, currentMin);       // update global min
            
            total += num;  // sum of all elements
        }
        
        // if all numbers are negative, maxSum is the answer
        if (maxSum < 0) {
            return maxSum;
        }
        
        // max of non-circular subarray or circular subarray (total - min subarray)
        return Math.max(maxSum, total - minSum);
    }
}
