class Solution { // Define a class named Solution
    public void sortColors(int[] nums) { // Method to sort colors (0s, 1s, 2s)
        int low = 0, mid = 0, high = nums.length - 1; // Initialize pointers: low and mid at start, high at end

        while (mid <= high) { // Loop until mid crosses high
            if (nums[mid] == 0) { // If current element is 0
                swap(nums, low, mid); // Swap it to the front
                low++; // Move low pointer forward
                mid++; // Move mid pointer forward
            } 
            else if (nums[mid] == 1) { // If current element is 1
                mid++; // Just move mid forward (keep 1 in place)
            } 
            else { // If current element is 2
                swap(nums, mid, high); // Swap it to the back
                high--; // Move high pointer backward
            }
        }
    }

    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) { // Takes array and two indices
        int temp = nums[i]; // Store first value in temp
        nums[i] = nums[j]; // Assign second value to first position
        nums[j] = temp; // Put temp (original first value) into second position
    }
}
