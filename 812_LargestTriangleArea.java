class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0; // store the maximum area found
        int n = points.length; // number of points

        // check all possible triplets of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // update maxArea with the largest area found so far
                    maxArea = Math.max(maxArea, area(points[i], points[j], points[k]));
                }
            }
        }
        return maxArea; // return the maximum area
    }

    // helper function to calculate area of triangle formed by 3 points
    private double area(int[] a, int[] b, int[] c) {
        return Math.abs(
            a[0] * (b[1] - c[1]) + // x1 * (y2 - y3)
            b[0] * (c[1] - a[1]) + // x2 * (y3 - y1)
            c[0] * (a[1] - b[1])   // x3 * (y1 - y2)
        ) / 2.0; // divide by 2 to get triangle area
    }
}
