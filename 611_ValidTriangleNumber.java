class Solution {
    public int triangleNumber(int[] nums) {
        // Sort the array so we can use two-pointer technique
        Arrays.sort(nums);

        // Variable to count valid triangles
        int count = 0;

        // Loop from the last element (largest side of triangle)
        for (int k = nums.length - 1; k >= 2; k--) {
            // Two pointers: start from left and right
            int i = 0, j = k - 1;

            // While left is before right
            while (i < j) {
                // If nums[i] + nums[j] > nums[k], then all pairs from i..j-1 with j are valid
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i); // add number of valid pairs
                    j--; // move right pointer left
                } else {
                    i++; // otherwise move left pointer right
                }
            }
        }

        // Return total count of valid triangles
        return count;
    }
}
