class Solution {
    public int compareVersion(String version1, String version2) {
        // Split version1 into parts wherever '.' is found
        String[] v1 = version1.split("\\.");
        // Split version2 into parts wherever '.' is found
        String[] v2 = version2.split("\\.");

        // Find the maximum length of the two version arrays
        int n = Math.max(v1.length, v2.length);

        // Loop through all parts up to the longest version length
        for (int i = 0; i < n; i++) {
            // Take current part of version1 as integer, if missing use 0
            int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            // Take current part of version2 as integer, if missing use 0
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;

            // Compare the numbers
            if (num1 < num2) {
                return -1; // version1 is smaller
            } else if (num1 > num2) {
                return 1;  // version1 is larger
            }
        }

        // If all parts are equal, versions are same
        return 0;
    }
}
