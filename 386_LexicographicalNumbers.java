class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(); // to store numbers in lexicographical order
        int curr = 1; // start from 1
        
        for (int i = 0; i < n; i++) {
            result.add(curr); // add current number to result
            
            // Try to go deeper by multiplying by 10 (e.g., 1 -> 10)
            if (curr * 10 <= n) {
                curr *= 10;
            } 
            // If current ends with 9 or exceeds n, move up and to next sibling
            else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10; // move up one level
                }
                curr++; // move to next number
            }
        }
        return result; // return the list
    }
}
