import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();  // TreeSet to maintain sorted window of elements
        
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            
            // find the smallest number >= num - valueDiff
            Long candidate = set.ceiling(num - (long)valueDiff);
            
            // check if candidate exists and within valueDiff range
            if (candidate != null && candidate <= num + (long)valueDiff)
                return true;
            
            set.add(num);  // add current number to set
            
            // maintain window size of indexDiff
            if (i >= indexDiff)
                set.remove((long) nums[i - indexDiff]);
        }
        
        return false;  // no valid pair found
    }
}
