package Data_Structure_Design.P460_LFU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    // key, value are input pairs
    // cnt : how many times this key value pairs has been retrieved so far from cache
    // prev, next: pointers of double linked list
    class Node {
        int key, val;
        int cnt;
        Node prev, next;

        // creating a new Node object will initialize count to be 1 in default
        public Node(int k, int v) {
            key = k;
            val = v;
            cnt = 1;
        }
    }

    // double linked list object
    // head, tail are dummy nodes with initialized key = 0 and value = 0
    // default length of this dll is 0
    class DLList {
        Node head, tail;
        int len;
        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        // time complexity O(1)
        public void addHead(Node node) {
            // retrieve next node which new inserted node should point to
            Node next = head.next;
            // establish connection between head and inputted node
            head.next = node;
            node.prev = head;
            // establish connection between node and original next node of head
            node.next = next;
            next.prev = node;
            // store this node's value and starting position in to hashmap
            map.put(node.key, node);
            // length of ddl increase by 1
            len++;
        }

        // time complexity O(1)
        public void remove(Node node) {
            // get the neighbors of node
            Node prev = node.prev;
            Node next = node.next;
            // link these two neighbors together, aka, unlink/skip this node from the ddl
            prev.next = next;
            next.prev = prev;
            // decrement length and remove this node from the hash map
            len--;
            map.remove(node.key);
        }

        // time complexity O(1)
        public void removeTail() {
            // retrieve the node before dummy tail node and call remove function on this node
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    // store value of the node and corresponding object itself
    Map<Integer, Node> map;
    // store frequency of a node and linked list starting from itself as head
    Map<Integer, DLList> freq;
    // size and capacity of the LFU cache
    int size, capacity;
    // maximum frequency so far in this cache
    int maxFreq;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        // invalid retrieval, return -1;
        if (map.get(key) == null) return -1;

        // retrieve the node object of this key
        Node node = map.get(key);
        // retrieve the frequency
        int prevFreq = node.cnt;
        // retrieve the linked list with head as this object
        DLList prevList = freq.get(prevFreq);
        // we need to remove this previous frequency, why?
        // because we will update this node's frequency and put the new key value pair
        // in the frequency hashmap
        prevList.remove(node);

        // calculate current frequency and update maximum frequency
        int curFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);

        // the current frequency may be occupied by other data set
        // if not, we initialize a new linked list
        DLList curList = freq.getOrDefault(curFreq, new DLList());

        // increment count of this node and add this node to the head of the list
        node.cnt++;
        curList.addHead(node);

        // put both frequency and corresponding linked list in the freq map
        freq.put(prevFreq, prevList);
        freq.put(curFreq, curList);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.get(key) != null) {
            map.get(key).val = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DLList curList = freq.getOrDefault(1, new DLList());
        curList.addHead(node);
        size++;

        if (size > capacity) {
            if (curList.len > 1) {
                curList.removeTail();
            } else {
                for (int i = 2; i <= maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }

            size--;
        }

        freq.put(1, curList);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 1);
    }
}
