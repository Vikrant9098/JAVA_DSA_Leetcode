class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;   // store length of array
        int ans = 0;           // to count valid selections

        // check every index in array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {  // only start where element is 0
                // try moving left
                if (canZeroAll(nums, i, -1)) ans++;
                // try moving right
                if (canZeroAll(nums, i, 1)) ans++;
            }
        }
        return ans;  // return total valid selections
    }

    // helper method to simulate the process
    private boolean canZeroAll(int[] nums, int start, int dir) {
        int[] arr = nums.clone(); // make a copy so original is not changed
        int n = arr.length;       // length of array
        int curr = start;         // current position

        // repeat until we move out of array bounds
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {   // if current element is 0
                curr += dir;        // move in the same direction
            } else {                // if element > 0
                arr[curr]--;        // decrease element by 1
                dir *= -1;          // reverse the direction
                curr += dir;        // move one step in new direction
            }
        }

        // after process, check if all elements became 0
        for (int val : arr)
            if (val != 0)          // if any value not zero
                return false;      // this selection is not valid

        return true;               // all zeros → valid selection
    }
}
