import java.util.*;

class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;  // Store key
            this.value = value;  // Store value
        }
    }

    private int capacity;  // Maximum capacity of cache
    private Map<Integer, Node> map;  // Map key → node for O(1) access
    private Node head, tail;  // Dummy head and tail of linked list

    public LRUCache(int capacity) {
        this.capacity = capacity;  // Set cache capacity
        map = new HashMap<>();  // Initialize map
        head = new Node(0, 0);  // Dummy head
        tail = new Node(0, 0);  // Dummy tail
        head.next = tail;  // Link head → tail
        tail.prev = head;  // Link tail → head
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;  // Key not found
        Node node = map.get(key);  // Get node
        remove(node);  // Remove from current position
        insertToFront(node);  // Move to front (most recently used)
        return node.value;  // Return value
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);  
            node.value = value;  // Update value
            remove(node);  // Remove from list
            insertToFront(node);  // Move to front
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;  // Least recently used node
                remove(lru);  // Remove LRU from list
                map.remove(lru.key);  // Remove LRU from map
            }
            Node newNode = new Node(key, value);  // Create new node
            insertToFront(newNode);  // Insert at front
            map.put(key, newNode);  // Add to map
        }
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;  // Skip node
        node.next.prev = node.prev;  // Skip node
    }

    // Insert a node right after head
    private void insertToFront(Node node) {
        node.next = head.next;  // Node points to first real node
        node.prev = head;  // Node points back to head
        head.next.prev = node;  // Link first real node back to node
        head.next = node;  // Link head → node
    }
}
