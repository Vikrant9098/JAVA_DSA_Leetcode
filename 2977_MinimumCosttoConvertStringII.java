class Solution {                     // Define Solution class

    static final long INF = Long.MAX_VALUE;   // Constant for infinite cost

    public long minimumCost(          // Method to calculate minimum cost
            String source,            // Original source string
            String target,            // Desired target string
            String[] original,        // Strings that can be replaced
            String[] changed,         // Strings after replacement
            int[] cost) {             // Cost of each replacement

        Map<String, Integer> id = new HashMap<>(); // Map each string to an ID
        Set<Integer> lens = new HashSet<>();       // Store possible substring lengths

        int sz = 0;                   // Count of unique strings
        int m = original.length;      // Number of transformation rules
        int n = source.length();      // Length of source string

        long[][] dist = new long[201][201]; // Distance matrix for costs

        for (long[] row : dist)       // Loop through each row
            Arrays.fill(row, INF);    // Fill row with infinite cost

        for (int i = 0; i < m; i++) { // Loop through all rules

            if (!id.containsKey(original[i])) {   // If original string not seen
                id.put(original[i], sz++);        // Assign new ID
                lens.add(original[i].length());   // Store its length
            }

            if (!id.containsKey(changed[i])) {    // If changed string not seen
                id.put(changed[i], sz++);         // Assign new ID
            }

            int u = id.get(original[i]);           // Get ID of original
            int v = id.get(changed[i]);            // Get ID of changed

            dist[u][v] = Math.min(dist[u][v], cost[i]); // Store minimum cost
        }

        for (int i = 0; i < sz; i++)  // Loop through all nodes
            dist[i][i] = 0;           // Cost to convert to itself is zero

        for (int k = 0; k < sz; k++)              // Floyd–Warshall outer loop
            for (int i = 0; i < sz; i++)          // Floyd–Warshall middle loop
                if (dist[i][k] != INF)            // If path i → k exists
                    for (int j = 0; j < sz; j++)  // Floyd–Warshall inner loop
                        if (dist[k][j] != INF)    // If path k → j exists
                            dist[i][j] = Math.min(   // Update shortest path
                                    dist[i][j],      // Current cost
                                    dist[i][k] + dist[k][j] // New path cost
                            );

        long[] dp = new long[n + 1];  // dp[i] = min cost till index i

        Arrays.fill(dp, INF);         // Initialize dp with infinite cost
        dp[0] = 0;                    // No cost for empty prefix

        for (int i = 0; i < n; i++) { // Traverse source string

            if (dp[i] == INF)         // If this position is unreachable
                continue;             // Skip this index

            if (source.charAt(i) == target.charAt(i)) // If characters match
                dp[i + 1] = Math.min(dp[i + 1], dp[i]); // Move without cost

            for (int L : lens) {      // Try all substring lengths

                if (i + L > n)        // If substring exceeds length
                    continue;         // Skip this length

                String s = source.substring(i, i + L); // Get source substring
                String t = target.substring(i, i + L); // Get target substring

                if (id.containsKey(s) && id.containsKey(t)) { // If both exist

                    long d = dist[id.get(s)][id.get(t)]; // Get conversion cost

                    if (d != INF)     // If conversion is possible
                        dp[i + L] = Math.min(dp[i + L], dp[i] + d); // Update dp
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n]; // Return result or -1 if impossible
    }
}
