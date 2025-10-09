class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); // to build the resulting binary string
        int i = a.length() - 1; // pointer for string a (start from the end)
        int j = b.length() - 1; // pointer for string b (start from the end)
        int carry = 0;           // carry for binary addition

        // loop until both strings are processed and no carry left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry; // start with carry

            if (i >= 0) {   // add current digit from a if available
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {   // add current digit from b if available
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2); // append current binary digit (0 or 1)
            carry = sum / 2;        // update carry
        }

        return result.reverse().toString(); // reverse result to get correct order
    }
}
