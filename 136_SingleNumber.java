class Solution 
{
    public int singleNumber(int[] nums) 
    {
        int result = 0;

        // loop through all numbers
        for (int num : nums) 
        {
            // XOR with result: duplicates cancel out
            result ^= num; 
        }

        // the remaining number is the one that appears only once
        return result;
    }
}
