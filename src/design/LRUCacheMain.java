package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
    }
}

// Have dummy head and tail nodes for handling the edge cases
class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node);
            addToHead(node);
            node.value = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        addToHead(node);
        count += 1;
        if (count > capacity) {
            Node tailNode = tail.prev;
            removeNode(tailNode);
            map.remove(tailNode.key);
            count -= 1;
        }
    }

    private void addToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        temp.prev = node;
        node.prev = head;
        node.next = temp;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
