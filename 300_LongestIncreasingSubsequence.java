import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // List to store the smallest tail of all increasing subsequences
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            // Find the first element in sub >= num
            int i = Collections.binarySearch(sub, num);

            // If not found, binarySearch returns (-insertion_point - 1)
            if (i < 0) i = -(i + 1);

            // If num is larger than all elements, add at the end
            if (i < sub.size()) sub.set(i, num); // Replace existing
            else sub.add(num); // Append to extend subsequence
        }

        return sub.size(); // Length of longest increasing subsequence
    }
}
