class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // create graph (list of lists)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) graph.add(new ArrayList<>()); // empty list for each station

        // add edges between stations
        for (int[] edge : connections) {
            graph.get(edge[0]).add(edge[1]); // connect u -> v
            graph.get(edge[1]).add(edge[0]); // connect v -> u
        }

        // array to store component id of each station
        int[] comp = new int[c + 1];
        int compId = 0; // start component counter

        // find connected components using DFS
        for (int i = 1; i <= c; i++) {
            if (comp[i] == 0) { // if not visited
                compId++; // new component id
                dfs(i, compId, comp, graph); // mark all connected stations
            }
        }

        // map: component id → sorted set of online stations
        Map<Integer, TreeSet<Integer>> compOnline = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int cid = comp[i]; // find component of station
            compOnline.putIfAbsent(cid, new TreeSet<>()); // create new set if not exist
            compOnline.get(cid).add(i); // add station to set
        }

        // track which stations are online
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true); // all start online

        // list to store answers of type-1 queries
        List<Integer> result = new ArrayList<>();

        // process each query
        for (int[] q : queries) {
            int type = q[0]; // query type
            int x = q[1];    // station number

            if (type == 1) { // maintenance check
                if (online[x]) { // if online
                    result.add(x); // return itself
                } else {
                    int cid = comp[x]; // get its component
                    TreeSet<Integer> set = compOnline.get(cid); // get online stations in it
                    if (set.isEmpty()) result.add(-1); // no online station
                    else result.add(set.first()); // smallest online station id
                }
            } else { // type == 2 → goes offline
                if (online[x]) { // only if it's online
                    online[x] = false; // mark offline
                    int cid = comp[x]; // get its component
                    compOnline.get(cid).remove(x); // remove from set
                }
            }
        }

        // convert list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i); // copy values
        return ans; // return result array
    }

    // DFS to mark connected components
    private void dfs(int node, int compId, int[] comp, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>(); // use stack for DFS
        stack.push(node); // start with given node
        comp[node] = compId; // mark its component

        while (!stack.isEmpty()) { // while stack not empty
            int cur = stack.pop(); // take top node
            for (int nei : graph.get(cur)) { // check its neighbors
                if (comp[nei] == 0) { // if not visited
                    comp[nei] = compId; // mark with same component
                    stack.push(nei); // add to stack
                }
            }
        }
    }
}
