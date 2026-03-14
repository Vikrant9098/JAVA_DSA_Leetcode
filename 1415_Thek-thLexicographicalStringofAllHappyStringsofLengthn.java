class Solution {

    int n2; // store original length of the string

    public String getHappyString(int n, int k) {
        n2 = n; // save original n to calculate remaining combinations
        return dfs(new StringBuilder(), n, k); // start building string using DFS
    }

    public String dfs(StringBuilder prefix, int n, int k){

        if (n == 0) // if required length reached
            return prefix.toString(); // return the built happy string

        for (char c = 'a'; c <= 'c'; c++) { // try characters a, b, c

            // skip if same as previous character (not a happy string)
            if (prefix.length() > 0 && c == prefix.charAt(prefix.length() - 1))
                continue;

            // number of valid strings possible after choosing this char
            int cnt = (int) Math.pow(2, n2 - prefix.length() - 1);

            // if kth string lies in this block, choose this char
            if (cnt >= k)
                return dfs(prefix.append(c), n - 1, k);

            // otherwise skip these cnt strings and reduce k
            else
                k -= cnt;
        }

        return ""; // if kth string does not exist
    }
}