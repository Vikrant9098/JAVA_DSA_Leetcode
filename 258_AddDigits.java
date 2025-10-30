class Solution {
    public int addDigits(int num) {
        // If number is 0, return 0 directly
        if (num == 0) return 0;
        
        // Use digital root formula: 1 + (num - 1) % 9
        // This gives the result in O(1) time without loops
        return 1 + (num - 1) % 9;
    }
}
