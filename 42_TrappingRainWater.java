class Solution {
    public int trap(int[] height) {
        // If less than 3 bars, no water can be trapped
        if (height.length < 3) {
            return 0;
        }

        // Two pointers: left starts at 0, right starts at end
        int left = 0, right = height.length - 1;

        // Track the maximum height seen so far from both sides
        int leftMax = height[left];
        int rightMax = height[right];

        // Variable to store total trapped water
        int water = 0;

        // Process bars until both pointers meet
        while (left < right) {
            // If left side is smaller, process from left
            if (leftMax < rightMax) {
                left++; // move left pointer
                // Update leftMax if current bar is taller
                leftMax = Math.max(leftMax, height[left]);
                // Water trapped at this position = leftMax - current height
                water += leftMax - height[left];
            } else {
                // Otherwise, process from right side
                right--; // move right pointer
                // Update rightMax if current bar is taller
                rightMax = Math.max(rightMax, height[right]);
                // Water trapped at this position = rightMax - current height
                water += rightMax - height[right];
            }
        }

        // Return total trapped water
        return water;
    }
}
