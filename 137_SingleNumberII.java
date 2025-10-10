class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;  // to store bits that have appeared once
        int twos = 0;  // to store bits that have appeared twice
        
        // Go through each number
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;  // update ones: add current bit if not in twos
            twos = (twos ^ num) & ~ones;  // update twos: add current bit if not in ones
        }
        
        // The bits that appeared once represent the single number
        return ones;
    }
}
