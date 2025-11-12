class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length; // get the length of array
        int ones = 0; // count how many elements are 1
        
        // count all 1's in the array
        for (int num : nums) {
            if (num == 1) ones++; // increase count if element is 1
        }
        
        // if we already have some 1's
        if (ones > 0) {
            return n - ones; // we only need to make the rest equal to 1
        }

        int minLen = Integer.MAX_VALUE; // store smallest subarray length having gcd = 1
        
        // check every possible subarray
        for (int i = 0; i < n; i++) {
            int g = nums[i]; // start gcd with first element
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]); // find gcd of current subarray
                if (g == 1) { // if gcd becomes 1
                    minLen = Math.min(minLen, j - i + 1); // update minimum length
                    break; // stop inner loop, gcd can't be less than 1
                }
            }
        }

        // if no subarray gives gcd = 1, it’s impossible
        if (minLen == Integer.MAX_VALUE) {
            return -1; // return -1 if we can’t make any 1
        }

        // (minLen - 1) to make one 1, (n - 1) to make all elements 1
        return (minLen - 1) + (n - 1);
    }

    // helper method to find gcd of two numbers
    private int gcd(int a, int b) {
        while (b != 0) { // loop until remainder is 0
            int temp = b; // store b temporarily
            b = a % b; // remainder becomes new b
            a = temp; // old b becomes new a
        }
        return a; // return the gcd
    }
}
