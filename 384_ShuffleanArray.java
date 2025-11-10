import java.util.*;

class Solution {
    private int[] original; // store the original array
    private int[] array;    // store the current (shuffled) array
    private Random rand;    // random generator

    public Solution(int[] nums) {
        original = nums.clone();  // keep a copy of the original array
        array = nums.clone();     // initialize current array
        rand = new Random();      // create Random object
    }

    public int[] reset() {
        array = original.clone(); // reset to original configuration
        return array;             // return original array
    }

    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {  // loop from end to start
            int j = rand.nextInt(i + 1);              // pick random index from 0 to i
            int temp = array[i];                      // swap elements
            array[i] = array[j];
            array[j] = temp;
        }
        return array;  // return shuffled array
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
