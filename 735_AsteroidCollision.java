class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Use a stack to track the ongoing state of asteroids
        Stack<Integer> stack = new Stack<>();

        // Iterate through each asteroid
        for (int asteroid : asteroids) {
            // Flag to check if current asteroid should be pushed
            boolean alive = true;

            // While stack has a positive asteroid and current is negative (collision condition)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -asteroid) {
                    // Top asteroid is smaller; it explodes
                    stack.pop();
                    // Continue loop to check with previous asteroids
                } else if (top == -asteroid) {
                    // Both asteroids are equal; both explode
                    stack.pop();
                    alive = false;  // current asteroid also destroyed
                    break;
                } else {
                    // Current asteroid is smaller; it explodes
                    alive = false;
                    break;
                }
            }

            // If current asteroid survived all possible collisions, push it
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to array and return result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
