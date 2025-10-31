/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n; // search range
        
        while (left < right) { // binary search
            int mid = left + (right - left) / 2; // avoid overflow
            if (isBadVersion(mid)) { // if mid is bad, search left part
                right = mid;
            } else { // else search right part
                left = mid + 1;
            }
        }
        return left; // first bad version found
    }
}
