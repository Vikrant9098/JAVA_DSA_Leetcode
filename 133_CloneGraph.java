/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class Solution {
    public Node cloneGraph(Node node) {
        // If the input graph is empty, just return null
        if (node == null) return null;

        // A map to store original node -> cloned node
        Map<Node, Node> visited = new HashMap<>();

        // Call DFS helper to clone starting from the given node
        return dfsClone(node, visited);
    }

    // Helper function to perform DFS cloning
    private Node dfsClone(Node node, Map<Node, Node> visited) {
        // If this node is already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone of the current node (just the value, empty neighbors for now)
        Node clone = new Node(node.val);

        // Store this clone in the map
        visited.put(node, clone);

        // Now, go through all neighbors of the original node
        for (Node neighbor : node.neighbors) {
            // Clone each neighbor using DFS and add to clone's neighbors list
            clone.neighbors.add(dfsClone(neighbor, visited));
        }

        // Return the fully cloned node
        return clone;
    }
}
