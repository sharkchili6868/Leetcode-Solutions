package Data_Structure_Design.P146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> cacheMap;
    int cache_capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        cacheMap = new HashMap<>(capacity);
        cache_capacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        Node node = cacheMap.get(key);
        if (node != null) {
            result = node.val;
            removeNode(node);
            addNode(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node != null) {
            removeNode(node);
            node.val = value;
            addNode(node);
        } else {
            if (cacheMap.size() == cache_capacity) {
                cacheMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            cacheMap.put(key, newNode);
            addNode(newNode);
        }
    }

    public void addNode(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}
