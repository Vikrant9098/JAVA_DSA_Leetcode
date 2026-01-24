class Solution {                       // Define the Solution class
    public int minPairSum(int[] nums) { // Method to find maximum pair sum after pairing
        int min = Integer.MAX_VALUE,    // Store minimum value in array
            max = Integer.MIN_VALUE;    // Store maximum value in array

        int[] freq = new int[100001];   // Frequency array for numbers (0 to 100000)

        for(int i = 0; i < nums.length; i++) { // Loop through all numbers
            if(nums[i] < min) min = nums[i];   // Update minimum value
            if(nums[i] > max) max = nums[i];   // Update maximum value
            freq[nums[i]]++;                   // Count frequency of current number
        }

        int max_sum = 0;               // Store the maximum pair sum
        int l = min, r = max;          // Two pointers from min and max values

        while(l <= r) {                // Continue until pointers cross
            if(freq[l] == 0) l++;      // Move left pointer if no element
            else if(freq[r] == 0) r--; // Move right pointer if no element
            else {
                max_sum = Math.max(max_sum, l + r); // Update max pair sum
                freq[l]--;              // Use one occurrence of l
                freq[r]--;              // Use one occurrence of r
            }
        }

        return max_sum;                // Return final maximum pair sum
    }
}
