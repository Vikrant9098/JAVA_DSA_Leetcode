class Solution {
    public boolean judgeCircle(String moves) {

        int x = 0, y = 0; // Start at origin (0,0)

        // Loop through each move in the string
        for (char move: moves.toCharArray()) {

            if (move == 'U') 
                y--; // Move up (decrease y)

            else if (move == 'D') 
                y++; // Move down (increase y)

            else if (move == 'L') 
                x--; // Move left (decrease x)

            else if (move == 'R') 
                x++; // Move right (increase x)
        }

        // Check if we returned to starting point
        return x == 0 && y == 0;
    }
}