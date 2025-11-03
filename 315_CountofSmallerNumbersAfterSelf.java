import java.util.*; // import utility package

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length; // store array length
        Integer[] result = new Integer[n]; // store result counts
        int[] indexes = new int[n]; // store original indexes
        
        for (int i = 0; i < n; i++) {
            indexes[i] = i; // set each index
            result[i] = 0;  // initialize result count as 0
        }

        mergeSort(nums, indexes, 0, n - 1, result); // call merge sort
        return Arrays.asList(result); // convert result array to list and return
    }

    private void mergeSort(int[] nums, int[] indexes, int left, int right, Integer[] result) {
        if (left >= right) return; // stop when only one element left

        int mid = (left + right) / 2; // find middle index
        mergeSort(nums, indexes, left, mid, result); // sort left part
        mergeSort(nums, indexes, mid + 1, right, result); // sort right part
        merge(nums, indexes, left, mid, right, result); // merge and count smaller numbers
    }

    private void merge(int[] nums, int[] indexes, int left, int mid, int right, Integer[] result) {
        int[] temp = new int[right - left + 1]; // temp array to store merged indexes
        int i = left, j = mid + 1, k = 0; // pointers for left, right, and temp
        int rightCount = 0; // count of smaller elements from right side

        // merge two sorted halves
        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k++] = indexes[j++]; // right element is smaller, add to temp
                rightCount++; // increase smaller count
            } else {
                result[indexes[i]] += rightCount; // add smaller count to result
                temp[k++] = indexes[i++]; // add left element to temp
            }
        }

        // process remaining left elements
        while (i <= mid) {
            result[indexes[i]] += rightCount; // add remaining smaller count
            temp[k++] = indexes[i++]; // move to temp
        }

        // process remaining right elements
        while (j <= right) {
            temp[k++] = indexes[j++]; // move right elements to temp
        }

        // copy merged result back to indexes
        for (int p = 0; p < temp.length; p++) {
            indexes[left + p] = temp[p]; // update indexes array
        }
    }
}
