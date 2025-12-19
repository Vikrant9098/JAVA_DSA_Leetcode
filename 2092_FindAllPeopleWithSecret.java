class Solution {

    // Main method to find all people who know the secret
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Map to store meetings grouped by time (time → meeting indexes)
        Map<Integer, List<Integer>> timeToIndexes = new TreeMap<>();

        // Total number of meetings
        int m = meetings.length;

        // Loop through all meetings
        for (int i = 0; i < m; i++) {

            // If time is not present, create empty list
            timeToIndexes.putIfAbsent(meetings[i][2], new ArrayList<>());

            // Store meeting index for that time
            timeToIndexes.get(meetings[i][2]).add(i);
        }

        // Create Union-Find structure for n people
        UF uf = new UF(n);

        // Person 0 shares secret with firstPerson initially
        uf.union(0, firstPerson);

        // Process meetings in increasing time order
        for (int time : timeToIndexes.keySet()) {

            // Set to store people involved at current time
            Set<Integer> pool = new HashSet<>();

            // Loop through all meetings at this time
            for (int ind : timeToIndexes.get(time)) {

                // Get current meeting
                int[] currentMeeting = meetings[ind];

                // Union the two people in the meeting
                uf.union(currentMeeting[0], currentMeeting[1]);

                // Add both people to the pool
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
            }

            // Reset connections for people who don't know the secret
            for (int i : pool)

                // If person is not connected to person 0
                if (!uf.connected(0, i))

                    // Break their union for future meetings
                    uf.reset(i);
        }

        // List to store final answer
        List<Integer> ans = new ArrayList<>();

        // Check all people
        for (int i = 0; i < n; i++)

            // If person is connected to person 0
            if (uf.connected(i, 0))

                // They know the secret
                ans.add(i);

        // Return list of people who know the secret
        return ans;
    }

    // Union-Find (Disjoint Set) class
    private static class UF {

        // Parent array for Union-Find
        int[] parent;

        // Rank array to keep tree shallow
        int[] rank;

        // Constructor
        public UF(int n) {

            // Initialize parent array
            parent = new int[n];

            // Initialize rank array
            rank = new int[n];

            // Initially each node is its own parent
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        // Union two nodes
        public void union(int p, int q) {

            // Find root of p
            int rootP = find(p);

            // Find root of q
            int rootQ = find(q);

            // If already in same set, do nothing
            if (rootP == rootQ)
                return;

            // Attach smaller rank tree under bigger one
            if (rank[rootP] < rank[rootQ]) {

                // Make rootQ parent
                parent[rootP] = rootQ;
            } else {

                // Make rootP parent
                parent[rootQ] = rootP;

                // Increase rank
                rank[rootP]++;
            }
        }

        // Find root with path compression
        public int find(int p) {

            // Move up until root is found
            while (parent[p] != p) {

                // Path compression step
                p = parent[parent[p]];
            }

            // Return root
            return p;
        }

        // Check if two nodes are connected
        public boolean connected(int p, int q) {

            // Compare roots
            return find(p) == find(q);
        }

        // Reset a node (disconnect it)
        public void reset(int p) {

            // Make node its own parent
            parent[p] = p;

            // Reset rank
            rank[p] = 0;
        }
    }
}
