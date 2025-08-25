class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        if (nums.length == 0) return 0; // Edge case: empty array
        int i = 0; // Pointer to track the position of unique elements

        // Iterate over the array
        for (int j = 1; j < nums.length; j++) 
        {
            if (nums[j] != nums[i]) 
            { 
                // If a new unique element is found
                i++; // Move pointer i to the next position
                nums[i] = nums[j]; // Place the unique element in its correct position
            }
        }
        
        return i + 1; // Length of unique elements 
    }
}

