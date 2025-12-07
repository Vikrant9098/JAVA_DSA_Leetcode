public class Solution {
    // count how many odd numbers are between low and high (inclusive)
    public int countOdds(int low, int high) {
        int nums = high - low + 1;   // total numbers between low and high (inclusive)
        
        if (low % 2 != 0 && high % 2 != 0)  // if both low and high are odd
            return nums / 2 + 1;            // then odds = half of nums plus one
        else
            return nums / 2;                // otherwise odds = exactly half of nums
    }

    // simple main method to test the function
    public static void main(String[] args) {
        Solution sol = new Solution();          // create Solution object
        System.out.println(sol.countOdds(3,7)); // example: prints 3 (odds: 3,5,7)
        System.out.println(sol.countOdds(2,4)); // example: prints 1 (odd: 3)
    }
}
