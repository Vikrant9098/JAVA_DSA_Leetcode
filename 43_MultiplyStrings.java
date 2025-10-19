class Solution {
    public String multiply(String num1, String num2) {
        // If either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();            // Length of num1
        int n = num2.length();            // Length of num2
        int[] pos = new int[m + n];       // Array to store intermediate multiplication results

        // Loop through each digit of num1 from end to start
        for (int i = m - 1; i >= 0; i--) {
            // Loop through each digit of num2 from end to start
            for (int j = n - 1; j >= 0; j--) {
                // Multiply current digits
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                int p1 = i + j;       // Tens position in pos array
                int p2 = i + j + 1;   // Ones position in pos array
                int sum = mul + pos[p2]; // Add multiplication result to existing value

                pos[p2] = sum % 10;   // Store ones place
                pos[p1] += sum / 10;  // Add carry to tens place
            }
        }

        StringBuilder sb = new StringBuilder(); // To build the final string

        // Convert pos array to string, skipping leading zeros
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) { // Skip leading zeros
                sb.append(p);                    // Append digit to string
            }
        }

        return sb.toString(); // Return the final product string
    }
}
