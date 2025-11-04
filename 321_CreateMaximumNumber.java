class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {  // main function
        int m = nums1.length, n = nums2.length;  // store lengths
        int[] best = new int[k];  // final best number
        
        // try all possible splits of k
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] part1 = maxSubsequence(nums1, i);      // pick i digits from nums1
            int[] part2 = maxSubsequence(nums2, k - i);  // pick remaining from nums2
            int[] candidate = merge(part1, part2);       // merge both parts
            
            if (greater(candidate, 0, best, 0)) {  // if new number is bigger
                best = candidate;  // update best
            }
        }
        return best;  // return final result
    }

    private int[] maxSubsequence(int[] nums, int k) {  // get largest subsequence
        int n = nums.length;  // store length
        int[] stack = new int[k];  // stack for chosen digits
        int top = 0;  // pointer for stack
        int toRemove = n - k;  // how many digits can be removed
        
        for (int num : nums) {  // go through each number
            while (top > 0 && stack[top - 1] < num && toRemove > 0) {  // if smaller digit before
                top--;       // remove it
                toRemove--;  // one removed
            }
            if (top < k) {           // if stack not full
                stack[top++] = num;  // add number
            } else {
                toRemove--;          // skip if can't add
            }
        }
        return stack;  // return result
    }

    private int[] merge(int[] nums1, int[] nums2) {  // merge two arrays
        int n1 = nums1.length, n2 = nums2.length;  // store lengths
        int[] merged = new int[n1 + n2];  // result array
        int i = 0, j = 0, idx = 0;  // pointers
        
        while (i < n1 || j < n2) {  // until both done
            if (greater(nums1, i, nums2, j)) {  // choose bigger sequence
                merged[idx++] = nums1[i++];  // take from nums1
            } else {
                merged[idx++] = nums2[j++];  // take from nums2
            }
        }
        return merged;  // return merged array
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {  // compare arrays
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {  // skip same digits
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);  // true if nums1 bigger
    }
}
