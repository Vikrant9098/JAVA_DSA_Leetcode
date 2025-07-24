class Solution {
    public int rob(int[] nums) {
        
        // Base case: If the array is empty, max sum is 0
        if (nums.length == 0) return 0;

        // Base case: If there's only 1 element, take max of 0 and nums[0]
        if (nums.length == 1) return Math.max(0, nums[0]);

        // Step 1: Initialize
        int incl = nums[0]; // max sum including the first element
        int excl = 0;       // max sum excluding the first element

        // Step 2: Loop through remaining elements
        for (int i = 1; i < nums.length; i++) {
            // Save the previous max of incl and excl (this becomes the new excl)
            int new_excl = Math.max(incl, excl);

            // incl now becomes sum of excl (previous) + current element
            incl = excl + nums[i];

            // update excl to the new_excl (best of previous choices)
            excl = new_excl;
        }

        // Step 3: Return the best of the two choices
        return Math.max(incl, excl);
    }
}