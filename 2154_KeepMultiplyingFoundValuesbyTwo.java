class Solution {
    public int findFinalValue(int[] nums, int original) {

        boolean found = true;          // to check if original is found in array

        while (found) {                // repeat until value is not found
            found = false;             // assume value is not found now

            for (int num : nums) {     // check every number in the array
                if (num == original) { // if current number matches original
                    original = original * 2; // multiply original by 2
                    found = true;      // mark as found so loop repeats
                    break;             // exit loop early since found
                }
            }
        }

        return original;               // return the final value
    }
}
