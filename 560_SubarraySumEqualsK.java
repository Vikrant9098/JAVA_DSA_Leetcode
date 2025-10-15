class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0; // total number of subarrays with sum = k
        int sum = 0;   // cumulative sum
        Map<Integer, Integer> map = new HashMap<>(); // store frequency of prefix sums
        map.put(0, 1); // base case: sum 0 occurs once

        for (int num : nums) {
            sum += num; // update cumulative sum
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // add number of times (sum - k) occurred
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // update frequency of current sum
        }

        return count; // return total count
    }
}
