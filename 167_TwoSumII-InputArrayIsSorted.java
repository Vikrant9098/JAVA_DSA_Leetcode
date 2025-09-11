class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // pointer at the start of the array
        int right = numbers.length - 1; // pointer at the end of the array

        // Keep checking until the two pointers meet
        while (left < right) {
            int sum = numbers[left] + numbers[right]; // calculate sum of two numbers

            if (sum == target) {
                // Found the pair : return 1-based indices
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // Sum too small : move left pointer to the right
            } else {
                right--; // Sum too big : move right pointer to the left
            }
        }

        // Should never reach here since problem guarantees one solution
        return new int[]{-1, -1};
    }
}
