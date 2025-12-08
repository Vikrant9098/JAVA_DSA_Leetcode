class Solution {                                      // start of Solution class

    public static int GCD(int x, int y){              // function to find GCD using binary + Euclid
        final int bx = Integer.numberOfTrailingZeros(x); // count trailing zeros in x
        final int by = Integer.numberOfTrailingZeros(y); // count trailing zeros in y
        final int bb = (bx < by) ? bx : by;           // take the smaller trailing zero count
        x >>= bx;                                     // divide x by 2^bx
        y >>= by;                                     // divide y by 2^by
        for (int r; y > 0; y = Math.min(y, r)) {      // loop until y becomes 0
            r = x % y;                                // compute remainder
            x = y;                                    // move y to x
            y = r;                                    // set y to remainder
        }
        return x << bb;                               // multiply back by 2^bb and return GCD
    }

    static public int countTriples(int n) {           // count number of valid triples up to n
        int cnt = 0;                                  // count of triples
        int nsqrt = (int)Math.sqrt((double)n);        // compute sqrt(n) as integer

        for (int s = 2; s <= nsqrt; s++) {            // loop s from 2 to sqrt(n)
            for (int t = 1 + (s & 1); t < s; t += 2) { // t starts with opposite parity of s

                if (GCD(s, t) != 1) continue;         // skip if s and t are not coprime

                int c = s * s + t * t;                // compute hypotenuse c = s² + t²

                if (c > n) break;                     // if c is too big, stop inner loop

                int kmax = n / c;                     // max multiplier k such that kc ≤ n

                cnt += 2 * kmax;                      // count (a,b,c) and (b,a,c) for all k
            }
        }

        return cnt;                                   // return final count
    }
}                                                     // end of class
