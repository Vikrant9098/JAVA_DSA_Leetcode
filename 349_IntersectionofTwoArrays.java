import java.util.*; // import utilities for using Set and HashSet

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(); // create a set for nums1

        for (int n : nums1) // loop through nums1
            set1.add(n); // add each element to set1 (removes duplicates)

        Set<Integer> result = new HashSet<>(); // create a set to store common numbers

        for (int n : nums2) { // loop through nums2
            if (set1.contains(n)) // check if element exists in set1
                result.add(n); // if yes, add to result set
        }

        int[] res = new int[result.size()]; // create array to store final answer
        int i = 0; // index for array

        for (int n : result) // loop through result set
            res[i++] = n; // put each number into array

        return res; // return final array
    }
}
