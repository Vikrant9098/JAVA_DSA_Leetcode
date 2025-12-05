class Solution {
    public int countPartitions(int[] nums) {

        int totalSum = 0;                   // stores the total sum of all elements
        for (int i = 0; i < nums.length; i++) {  // loop through the array
            totalSum += nums[i];            // add each element to totalSum
        }

        int leftSum = 0;                    // sum of the left part
        int count = 0;                      // number of valid partitions

        for (int i = 0; i < nums.length - 1; i++) {  // go till second last index
            leftSum += nums[i];             // add current element to leftSum
            int rightSum = totalSum - leftSum; // right sum is remaining elements

            // check if both left and right sums are even or both are odd
            if ((leftSum % 2) == (rightSum % 2)) {
                count++;                    // valid partition → increase count
            }
        }

        return count;                       // return the number of valid partitions
    }
}
