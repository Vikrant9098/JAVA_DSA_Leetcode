class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0; // to store number of operations
        
        // continue until either number becomes 0
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2; // subtract smaller number from larger
            } else {
                num2 -= num1; // subtract smaller number from larger
            }
            count++; // increment operation count
        }
        
        return count; // return total number of operations
    }
}
