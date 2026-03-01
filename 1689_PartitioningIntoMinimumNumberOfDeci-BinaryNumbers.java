class Solution {     

    public int minPartitions(String n) {  
        // Convert the string into an IntStream of character ASCII values,
        // find the maximum character, get its integer value,
        // then subtract '0' to convert ASCII digit to actual number.
        // This gives the largest digit in the string.
        return n.chars().max().getAsInt() - '0';  
    } 
}