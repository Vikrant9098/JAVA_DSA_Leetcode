class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Area of first rectangle
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        
        // Area of second rectangle
        int areaB = (bx2 - bx1) * (by2 - by1);
        
        // Find overlap width (intersection in x direction)
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        
        // Find overlap height (intersection in y direction)
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        
        int overlapArea = 0; // Initialize overlap area
        
        // If rectangles actually overlap (width and height > 0)
        if (overlapWidth > 0 && overlapHeight > 0) {
            overlapArea = overlapWidth * overlapHeight;
        }
        
        // Total area = sum of both areas - overlapped area
        return areaA + areaB - overlapArea;
    }
}
