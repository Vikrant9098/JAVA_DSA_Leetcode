class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        int[] temp = new int[n]; // Create a temporary array

        // Copy the last k elements to the beginning of temp
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Copy the first (n - k) elements to temp after k elements
        for (int i = 0; i < n - k; i++) {
            temp[k + i] = nums[i];
        }

        // Copy back the rotated array to nums
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
