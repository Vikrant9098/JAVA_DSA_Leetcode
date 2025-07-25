class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];  // to store result from 0 to n

        // base case
        ans[0] = 0;

        // fill the array using the relation:
        // ans[i] = ans[i / 2] + (i % 2)
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
            // i >> 1 is same as i / 2
            // i & 1 is 1 if i is odd, 0 if even (i % 2)
        }

        return ans;
    }
}
