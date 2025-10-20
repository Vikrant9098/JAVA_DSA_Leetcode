class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0; // initialize X to 0
        for (String op : operations) { // loop through each operation
            if (op.contains("++")) { // check if operation is increment
                x++; // increment X by 1
            } else {
                x--; // otherwise, decrement X by 1
            }
        }
        return x; // return final value of X
    }
}
