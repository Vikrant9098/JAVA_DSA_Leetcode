import java.util.List;

class Solution { 
    // Defines the Solution class (required by the platform)

    public int[] minBitwiseArray(List<Integer> nums) {
        // Function that takes a list of integers and returns an int array

        int ans[] = new int[nums.size()];
        // Create result array of same size as input list

        for(int i = 0; i < nums.size(); i++) {
            // Loop through each element in nums

            int n = nums.get(i);
            // Get the current number from the list

            if(n != 2)
                // Check if the number is not equal to 2

                ans[i] = n - ((n + 1) & (-n - 1)) / 2;
                // Compute the minimum value using bitwise operation
                // (n+1) & (-n-1) finds the lowest set bit pattern
                // Dividing by 2 adjusts it, subtracting gives the answer

            else
                // If the number is exactly 2

                ans[i] = -1;
                // No valid value exists, so store -1
        }  

        return ans;
        // Return the final result array
    }
}
