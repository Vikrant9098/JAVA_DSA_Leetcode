class Solution {
    public boolean isHappy(int n) {
        // Set to keep track of numbers we have already seen (to detect cycles)
        Set<Integer> seen = new HashSet<>();
        
        // Keep running until we reach 1 (happy) or loop forever (unhappy)
        while (n != 1 && !seen.contains(n)) {
            seen.add(n); // Mark current number as seen
            n = getSumOfSquares(n); // Replace n with sum of squares of its digits
        }
        
        return n == 1; // If we reached 1, it's a happy number
    }

    // Helper method to calculate sum of squares of digits
    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // Get last digit
            sum += digit * digit; // Add square of digit to sum
            num /= 10; // Remove last digit
        }
        return sum;
    }
}
