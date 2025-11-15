class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(); // length of string
        int[] prefix = new int[n]; // prefix sum of '1's

        prefix[0] = ((int)(s.charAt(0) - '0')) == 1 ? 1 : 0; // first prefix value
        for (int i = 1; i < n; i++) { // build prefix array
            prefix[i] = prefix[i - 1] + (((int)(s.charAt(i) - '0')) == 1 ? 1 : 0); // add 1 if char is '1'
        }

        int ans = 0; // final answer

        for (int i = 0; i < n; i++) { // i = start of substring
            int one = 0; // count of '1's
            int zero = 0; // count of '0's

            for (int j = i; j < n; j++) { // j = end of substring

                one = prefix[j] - (i == 0 ? 0 : prefix[i - 1]); // number of '1's in substring
                zero = (j - i + 1) - one; // number of '0's

                // CASE 1: not dominant
                if ((zero * zero) > one) { 
                    j += (zero * zero - one - 1); // skip ahead because next also won't be dominant
                } 
                // CASE 2: exactly dominant
                else if ((zero * zero) == one) { 
                    ans++; // count this substring
                } 
                // CASE 3: strongly dominant
                else if ((zero * zero) < one) { 
                    ans++; // count this one

                    int diff = (int) Math.sqrt(one) - zero; // how many more will be dominant
                    int nextj = j + diff; // jump ahead

                    if (nextj >= n) { // if jump goes outside
                        ans += (n - j - 1); // count all remaining
                    } else {
                        ans += diff; // count skipped dominant substrings
                    }

                    j = nextj; // move j to new position
                }
            }
        }

        return ans; // final result
    }
}
