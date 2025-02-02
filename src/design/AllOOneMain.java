package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// To remember :
// 1. Create head and tail dummy nodes and connect them.
// 2. Only insert the node if the node is not part of the list currently.
// (As when we run getNext method to get the next node, we might get a node that is already in the list)
// 3. Use insertNext(Node current, Node next) method to insert new node into the list.
// 4. Use removeNode(Node node) to remove a node
// 5. Use a getNext(Node) and getPrev(Node) method to get nodes with +1 or -1 frequency. Create new node if not already there, then insert them using created methods.
// 6. When we increment, we remove last node, and when we decrement, we might come to head node. We do not have to add or remove from head node set.
public class AllOOneMain {
    public static void main(String args[]) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("leet");
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey());
    }
}

class AllOne {
    Node head;
    Node tail;
    Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        Node curr = map.getOrDefault(key, head);
        if (curr.set.contains(key)) {
            curr.set.remove(key);
        }
        Node next = getNext(curr);
        next.set.add(key);
        map.put(key, next);
        if (next.next == null) {
            insertNext(curr, next);
        }
        if (curr != head && curr.set.size() == 0) {
            removeNode(curr);
        }
    }

    public void dec(String key) {
        Node curr = map.get(key);
        curr.set.remove(key);
        Node prev = getPrev(curr);
        map.put(key, prev);
        if (prev != head) {
            prev.set.add(key);
        }
        if (prev.next == null) {
            insertNext(curr.prev, prev);
        }
        if (curr.set.isEmpty()) {
            removeNode(curr);
        }
    }

    public String getMaxKey() {
        return tail.prev.set.isEmpty() ? "" : tail.prev.set.iterator().next();
    }

    public String getMinKey() {
        return head.next.set.isEmpty() ? "" : head.next.set.iterator().next();
    }

    private Node getNext(Node node) {
        if (node.next.frequency == node.frequency+1) {
            return node.next;
        }
        return new Node(node.frequency+1);
    }

    private Node getPrev(Node node) {
        if (node.prev.frequency == node.frequency-1) {
            return node.prev;
        }
        return new Node(node.frequency-1);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNext(Node curr, Node ins) {
        ins.next = curr.next;
        curr.next.prev = ins;
        curr.next = ins;
        ins.prev = curr;
    }

    class Node {
        private Set<String> set;
        private Integer frequency;
        private Node next;
        private Node prev;
        public Node() {
            set = new HashSet<>();
        }
        public Node(int frequency) {
            set = new HashSet<>();
            this.frequency = frequency;
        }
    }
}
