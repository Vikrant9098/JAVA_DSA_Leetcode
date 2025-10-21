class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // Get array length and initialize variables
        int n = nums.length, ans = 0, left = 0, right = 0;

        // Sort the array to make range checks easier
        Arrays.sort(nums);

        // Map to count frequency of each number
        HashMap<Integer, Integer> count = new HashMap<>();

        // Count occurrences of each number
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        // -------- First Pass: pick an existing number as target --------
        for(int mid = 0; mid < n; mid++) {
            // Move left pointer while current range exceeds k
            while(nums[mid] - nums[left] > k) {
                left++;
            }

            // Move right pointer while next number is within k range
            while(right < n - 1 && nums[right + 1] - nums[mid] <= k) {
                right++;
            }

            // Count total numbers within [left, right]
            int total = right - left + 1;

            // Calculate max frequency using available operations
            ans = Math.max(ans, Math.min(total - count.get(nums[mid]), numOperations) + count.get(nums[mid]));
        }

        // -------- Second Pass: pick a number not in array as target --------
        left = 0; // reset left pointer

        // Move right pointer through array
        for(right = 0; right < n; right++) {
            // Take middle value between nums[left] and nums[right]
            int mid = (nums[left] + nums[right]) / 2;

            // Adjust left pointer if mid goes out of k range
            while(mid - nums[left] > k || nums[right] - mid > k) {
                left++;
                mid = (nums[left] + nums[right]) / 2; // recalculate mid
            }

            // Update answer with possible max frequency
            ans = Math.max(ans, Math.min(right - left + 1, numOperations));
        }

        // Return maximum frequency found
        return ans;
    }
}
