class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph using a HashMap
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build bidirectional weighted graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);  // numerator
            String v = equations.get(i).get(1);  // denominator
            double val = values[i];              // u / v = val

            // Add edge u -> v with weight val
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);

            // Add edge v -> u with weight 1/val
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }

        double[] result = new double[queries.size()];  // Store result for each query

        // Step 2: Process each query using DFS
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);  // source variable
            String dst = queries.get(i).get(1);  // destination variable

            // If either src or dst is not in graph, answer is -1
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
            } else if (src.equals(dst)) {
                // If both variables are the same, result is 1
                result[i] = 1.0;
            } else {
                // Use DFS to compute result
                Set<String> visited = new HashSet<>();
                result[i] = dfs(src, dst, graph, visited, 1.0);
            }
        }

        return result;
    }

    // DFS helper function to find product path from src to dst
    private double dfs(String src, String dst, Map<String, Map<String, Double>> graph, Set<String> visited, double product) {
        // If we've reached the destination, return the product
        if (src.equals(dst)) return product;

        visited.add(src);  // Mark current node as visited

        // Visit all neighbors
        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            String next = neighbor.getKey();         // neighbor node
            double val = neighbor.getValue();        // weight (src / next)

            if (!visited.contains(next)) {
                // Recursive DFS: accumulate the result
                double result = dfs(next, dst, graph, visited, product * val);
                if (result != -1.0) return result;    // early return if found
            }
        }

        return -1.0;  // No valid path found
    }
}
