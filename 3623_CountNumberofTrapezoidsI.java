class Solution {
    static final long MOD = 1_000_000_007; // modulo value

    public int countTrapezoids(int[][] points) {
        // map to store how many points exist on each y-level
        HashMap<Integer, Integer> map = new HashMap<>();

        // count points for each y-coordinate
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        long sum = 0;      // total of all C(k,2) values
        long sumSq = 0;    // total of (C(k,2))^2 values

        // loop through all y-level counts
        for (int k : map.values()) {
            if (k >= 2) { // need at least 2 points to form a horizontal segment
                long c = ((long) k * (k - 1) / 2) % MOD; // compute C(k,2)
                sum = (sum + c) % MOD; // add to sum
                sumSq = (sumSq + (c * c) % MOD) % MOD; // add c² to sumSq
            }
        }

        // apply formula: (sum² - sumSq) / 2
        long result = (sum * sum) % MOD; // compute sum²
        result = (result - sumSq + MOD) % MOD; // subtract sumSq safely
        result = (result * inv2()) % MOD; // multiply by inverse of 2

        return (int) result; // return final answer
    }

    // function to return modular inverse of 2
    private long inv2() {
        return (MOD + 1) / 2; // inverse of 2 under prime mod
    }
}
