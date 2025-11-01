class Solution {
    public boolean canWinNim(int n) {
        // You lose only when n is a multiple of 4
        // because whatever you pick (1, 2, or 3),
        // the opponent can always pick to make the sum 4
        return n % 4 != 0;
    }
}
