class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        
        // Loop until the third last index (since we check substrings of length 3)
        for (int i = 0; i <= num.length() - 3; i++) {
            String sub = num.substring(i, i + 3); // Take substring of length 3
            
            // Check if all three characters are the same
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                // Compare lexicographically to get the largest
                if (maxGood.equals("") || sub.compareTo(maxGood) > 0) {
                    maxGood = sub;
                }
            }
        }
        
        return maxGood;
    }
}
