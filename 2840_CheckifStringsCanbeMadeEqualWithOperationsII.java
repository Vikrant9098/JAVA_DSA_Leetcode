class Solution {
    public boolean checkStrings(String s1, String s2) {

        // Assign a unique prime number to each lowercase English letter (a → z)
        int[] prime = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        };

        // Mod value to prevent overflow and keep numbers within range
        long mod = 1000000007L;

        // h1 and h2 store hash values:
        // index 0 → even indices product
        // index 1 → odd indices product
        long[] h1 = {1, 1};
        long[] h2 = {1, 1};

        // Traverse both strings
        for (int i = 0; i < s1.length(); i++) {

            // Determine whether index is even (0) or odd (1)
            int off = i & 1;

            // Multiply the corresponding prime value for character in s1
            // into even/odd bucket and take modulo
            h1[off] = (h1[off] * prime[s1.charAt(i) - 'a']) % mod;

            // Do the same for s2
            h2[off] = (h2[off] * prime[s2.charAt(i) - 'a']) % mod;
        }

        // Compare both even-indexed hashes and odd-indexed hashes
        // If both match, strings are considered equivalent
        return h1[0] == h2[0] && h1[1] == h2[1];
    }
}