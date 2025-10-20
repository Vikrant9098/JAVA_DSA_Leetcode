import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();  // List to hold numbers 1 to n
        int[] fact = new int[n + 1];                // Array to store factorials

        fact[0] = 1;  // 0! = 1
        // Compute all factorials up to n!
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);  // Add numbers 1, 2, 3, ..., n
        }

        k--;  // Convert k to 0-based index
        StringBuilder sb = new StringBuilder();  // To build the permutation string

        // Build permutation by selecting one digit at a time
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];  // Determine which number to pick
            sb.append(numbers.get(index));  // Add selected number to result
            numbers.remove(index);          // Remove used number
            k %= fact[i - 1];               // Update k for remaining digits
        }

        return sb.toString();  // Return the kth permutation as string
    }
}
