import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // map each airport to its destinations (sorted using PriorityQueue)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // build the graph from all tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0); // starting airport
            String to = ticket.get(1);   // destination airport
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to); // add destination in sorted order
        }

        LinkedList<String> route = new LinkedList<>(); // list to store final route

        // start DFS from "JFK"
        dfs("JFK", graph, route);

        return route; // return the final route
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {
        PriorityQueue<String> dests = graph.get(airport); // get destinations from this airport
        while (dests != null && !dests.isEmpty()) { // visit while destinations remain
            String next = dests.poll(); // pick the smallest (lexical) destination
            dfs(next, graph, route); // visit next airport
        }
        route.addFirst(airport); // add airport to front after exploring all paths
    }
}
