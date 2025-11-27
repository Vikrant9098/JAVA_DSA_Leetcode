class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        final long n = nums.length, INF = Long.MAX_VALUE / 2;  
        // n = size of array, INF = a very large number (used as initial value)

        long[] minS = new long[k];  
        // minS stores the minimum prefix sum for each remainder group (0 to k-1)

        for (int i = 0; i < k - 1; i++) minS[i] = INF;  
        // fill all positions except last with INF

        minS[k - 1] = 0;  
        // remainder = -1 mod k (before start), so prefix sum = 0 at remainder k-1

        long prefix = 0, ans = -INF;  
        // prefix = running prefix sum, ans = store maximum result

        for (int i = 0; i < n; i++) {  
            // loop through each element

            prefix += nums[i];  
            // update prefix sum

            int ik = i % k;  
            // find remainder index based on current position

            ans = Math.max(ans, prefix - minS[ik]);  
            // try making subarray sum = current prefix - earliest prefix with same remainder

            minS[ik] = Math.min(prefix, minS[ik]);  
            // update the minimum prefix sum for this remainder group
        }

        return ans;  
        // return the maximum subarray sum found
    }
}
