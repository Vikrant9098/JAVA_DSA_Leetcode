import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(); // List to store gray code sequence
        result.add(0);                             // Start sequence with 0

        for (int i = 0; i < n; i++) {             // Loop through each bit position
            int size = result.size();             // Current size of sequence
            for (int j = size - 1; j >= 0; j--) { // Loop backwards through current sequence
                result.add(result.get(j) | (1 << i)); // Add new numbers by flipping the i-th bit
            }
        }

        return result;                             // Return final gray code sequence
    }
}
