class Solution { 
    // Solution class

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // Method to find the largest square area from overlapping rectangles

        int ans = 0, n = bottomLeft.length;
        // ans stores max square side, n is number of rectangles

        for (int i = 0; i < n; i++) {
            // Loop for first rectangle

            int[] firstRectBL = bottomLeft[i];
            // Bottom-left corner of first rectangle

            int[] firstRectTR = topRight[i];
            // Top-right corner of first rectangle

            for (int j = i + 1; j < n; j++) {
                // Loop for second rectangle (pair checking)

                int[] secondRectBL = bottomLeft[j];
                // Bottom-left corner of second rectangle

                int[] secondRectTR = topRight[j];
                // Top-right corner of second rectangle

                if (secondRectBL[0] >= firstRectTR[0] || secondRectTR[0] <= firstRectBL[0]) continue;
                // Skip if rectangles do NOT overlap horizontally

                if (secondRectTR[1] <= firstRectBL[1] || secondRectBL[1] >= firstRectTR[1]) continue;
                // Skip if rectangles do NOT overlap vertically

                int pntAx = Math.max(firstRectBL[0], secondRectBL[0]);
                // Left x-coordinate of overlap area

                int pntAy = Math.max(firstRectBL[1], secondRectBL[1]);
                // Bottom y-coordinate of overlap area

                int pntBx = Math.min(firstRectTR[0], secondRectTR[0]);
                // Right x-coordinate of overlap area

                int pntBy = Math.min(firstRectTR[1], secondRectTR[1]);
                // Top y-coordinate of overlap area

                int sideA = pntBx - pntAx;
                // Width of overlapping rectangle

                int sideB = pntBy - pntAy;
                // Height of overlapping rectangle

                ans = Math.max(ans, Math.min(sideA, sideB));
                // Choose largest possible square side from overlap
            }
        }

        return (long) ans * ans;
        // Return area of largest square
    }
}
