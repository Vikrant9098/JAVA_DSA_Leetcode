class Solution 
{
    // Main function to find the GCD string of two input strings
    public String gcdOfStrings(String str1, String str2) 
    {
        // Check if str1 + str2 is same as str2 + str1
        // If not, there is no common GCD string
        if (!(str1 + str2).equals(str2 + str1)) 
        {
            return ""; // Return empty string as they don't share a common pattern
        }

        // Find GCD of lengths of both strings
        int gcdlength = gcd(str1.length(), str2.length());

        // Return substring of str1 from 0 to gcdlength
        return str1.substring(0, gcdlength);
    }

    // Helper function to find GCD of two integers using Euclidean algorithm
    private int gcd(int a, int b) 
    {
        // Repeat until remainder becomes 0
        while (b != 0) 
        {
            int temp = b;   // Store b temporarily
            b = a % b;      // b becomes remainder of a divided by b
            a = temp;       // a becomes previous b
        }

        return a; // a is the GCD
    }
}
