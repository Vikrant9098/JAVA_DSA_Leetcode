import java.util.Arrays;

public class Solution { // Define the Solution class
    public int[] sortByBits(int[] arr) { // Method to sort array based on number of 1 bits in binary form
        
        // Convert primitive int[] to Integer[] (boxing) because custom comparator works with objects
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        // Sort the Integer array using custom comparator (lambda function)
        Arrays.sort(boxedArray, (a, b) -> {
            
            // Count number of set bits (1s) in binary representation of a
            int countA = Integer.bitCount(a);
            
            // Count number of set bits (1s) in binary representation of b
            int countB = Integer.bitCount(b);
            
            // If both have same number of set bits, sort by normal integer value
            // Otherwise, sort by difference in set bit count
            return countA == countB ? a - b : countA - countB;
        });
        
        // Convert Integer[] back to primitive int[] (unboxing) and return result
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }
}