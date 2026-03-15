import java.util.ArrayList;

class Fancy {
    private static final int MOD = 1000000007; // modulo for large numbers
    private ArrayList<Long> val;               // stores normalized values
    private long a, b;                         // global multiplier (a) and adder (b)

    public Fancy() {
        val = new ArrayList<>(); // initialize list
        a = 1;                   // initial multiplier
        b = 0;                   // initial addition
    }

    // fast modular exponentiation (x^y % mod)
    private long modPow(long x, long y, long mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1) {             // if y is odd
                res = (res * x) % mod;    // multiply result
            }
            y = y / 2;                    // halve exponent
            x = (x * x) % mod;            // square base
        }
        return res;
    }

    public void append(int val) {
        // reverse current transformation to store base value
        long x = (val - b + MOD) % MOD;

        // divide by 'a' using modular inverse of a
        this.val.add((x * modPow(a, MOD - 2, MOD)) % MOD);
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD; // update global addition
    }

    public void multAll(int m) {
        a = (a * m) % MOD; // scale multiplier
        b = (b * m) % MOD; // scale addition as well
    }

    public int getIndex(int idx) {
        if (idx >= val.size()) return -1; // index out of bounds

        // apply current transformation to stored base value
        return (int)((a * val.get(idx) + b) % MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */