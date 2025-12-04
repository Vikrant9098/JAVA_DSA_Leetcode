class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();     // length of the string
        int i = 0, j = n - 1;            // two pointers: start and end

        // Skip all leading 'L' cars (they move left and never collide)
        while (i < n && directions.charAt(i) == 'L') i++;

        // Skip all trailing 'R' cars (they move right and never collide)
        while (j >= 0 && directions.charAt(j) == 'R') j--;

        int collisions = 0;              // store total collisions

        // Count cars in the middle that are not 'S'
        for (int k = i; k <= j; k++) {   // loop through active collision zone
            if (directions.charAt(k) != 'S') 
                collisions++;            // each 'L' or 'R' here will collide
        }

        return collisions;               // return total collisions
    }
}
