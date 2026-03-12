class DSU {
    int[] parent;     // stores parent of each node
    int[] rank;       // stores tree height for union by rank
    int components;   // number of connected components

    public DSU(int n) {
        parent = new int[n];   // initialize parent array
        rank = new int[n];     // initialize rank array
        components = n;        // initially every node is its own component

        for (int i = 0; i < n; i++) {
            parent[i] = i;     // each node is its own parent initially
        }
    }

    public int find(int x) {
        if (parent[x] != x) {           // if x is not root
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];               // return root parent
    }

    public boolean unite(int a, int b) {
        int pa = find(a);   // find root of a
        int pb = find(b);   // find root of b

        if (pa == pb) return false; // already connected → cycle

        if (rank[pa] < rank[pb]) {  // ensure pa has higher rank
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;   // attach pb tree under pa

        if (rank[pa] == rank[pb]) { // if ranks equal increase rank
            rank[pa]++;
        }

        components--;      // two components merged
        return true;       // union successful
    }
}

class Solution {

    public boolean canAchieve(int n, int[][] edges, int k, int x) {
        DSU dsu = new DSU(n); // create DSU for connectivity

        // Step 1: process mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {          // mandatory edge
                if (s < x) return false;  // stability too low → impossible
                if (!dsu.unite(u, v)) return false; // cycle in mandatory edges
            }
        }

        // Step 2: add optional edges that already satisfy stability
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s >= x) { // optional edge with enough stability
                dsu.unite(u, v);       // connect components for free
            }
        }

        // Step 3: use upgrades for weak optional edges
        int usedUpgrades = 0; // track number of upgrades used

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s < x && 2 * s >= x) { // edge can reach x after upgrade
                if (dsu.unite(u, v)) { // connect if it links different components
                    usedUpgrades++;    // consume one upgrade
                    if (usedUpgrades > k) return false; // exceed upgrade limit
                }
            }
        }

        return dsu.components == 1; // check if graph fully connected
    }

    public int maxStability(int n, int[][] edges, int k) {

        // Step 0: check if mandatory edges already create a cycle
        DSU dsu = new DSU(n);

        for (int[] e : edges) {
            if (e[3] == 1) { // mandatory edge
                if (!dsu.unite(e[0], e[1])) {
                    return -1; // cycle → impossible to form tree
                }
            }
        }

        int low = 1, high = 200000; // search range of stability
        int ans = -1;               // best achievable stability

        while (low <= high) {
            int mid = low + (high - low) / 2; // candidate stability

            if (canAchieve(n, edges, k, mid)) { // check feasibility
                ans = mid;       // update answer
                low = mid + 1;   // try higher stability
            } else {
                high = mid - 1;  // try lower stability
            }
        }

        return ans; // maximum achievable stability
    }
}