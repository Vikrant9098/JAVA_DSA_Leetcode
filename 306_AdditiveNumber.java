class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();  // get length of string
        
        // try all possible first and second number splits
        for (int i = 1; i <= n / 2; i++) {
            // if first number starts with 0 and has more digits, skip
            if (num.charAt(0) == '0' && i > 1) break;
            
            long first = Long.parseLong(num.substring(0, i));  // get first number
            
            // try all possible second numbers
            for (int j = i + 1; n - j >= j - i && n - j >= i; j++) {
                // if second number starts with 0 and has more digits, skip
                if (num.charAt(i) == '0' && j - i > 1) break;
                
                long second = Long.parseLong(num.substring(i, j));  // get second number
                
                // check if rest of string forms valid additive sequence
                if (isValid(first, second, num.substring(j))) return true;
            }
        }
        return false;  // no valid sequence found
    }

    // helper method to check if the rest forms additive sequence
    private boolean isValid(long first, long second, String remaining) {
        while (!remaining.isEmpty()) {  // loop until no digits left
            long sum = first + second;  // find next number
            String sumStr = String.valueOf(sum);  // convert sum to string

            // if remaining part doesn’t start with this sum, not valid
            if (!remaining.startsWith(sumStr)) return false;
            
            // cut the used part from remaining
            remaining = remaining.substring(sumStr.length());
            
            // move numbers forward
            first = second;
            second = sum;
        }
        return true;  // valid additive sequence
    }
}
