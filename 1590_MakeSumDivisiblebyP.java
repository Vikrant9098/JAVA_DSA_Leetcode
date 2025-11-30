import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {

        long totalSum = 0;                 // store total sum of the array
        for (int num : nums) {             // loop through each number
            totalSum += num;               // add number to total sum
        }

        int rem = (int)(totalSum % p);     // remainder when total sum is divided by p
        if (rem == 0) return 0;            // if remainder is 0, no need to remove any subarray

        HashMap<Integer, Integer> prefixMod = new HashMap<>(); // map to store prefix sum mod and index
        prefixMod.put(0, -1);              // set base case for full prefix
        long prefixSum = 0;                // running prefix sum
        int minLength = nums.length;       // track minimum subarray length

        for (int i = 0; i < nums.length; ++i) { // loop through array
            prefixSum += nums[i];                  // update prefix sum
            int currentMod = (int)(prefixSum % p); // mod of current prefix sum
            int targetMod = (currentMod - rem + p) % p; // required mod to match

            if (prefixMod.containsKey(targetMod)) {     // if we saw this mod before
                minLength = Math.min(minLength, i - prefixMod.get(targetMod)); // update answer
            }

            prefixMod.put(currentMod, i); // store current mod with index
        }

        return minLength == nums.length ? -1 : minLength; // if unchanged, return -1 else min length
    }
}
