package trie;

import java.util.HashMap;
import java.util.Map;

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int n = word.length();
        Node curr = root;
        for (int i = 0; i < n; i++) {
            Node next = curr.map.get(word.charAt(i));
            if (next == null) {
                next = new Node();
                curr.map.put(word.charAt(i), next);
            }
            curr = next;
            if (i == n-1) {
                curr.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        return check(word, true);
    }

    public boolean startsWith(String prefix) {
        return check(prefix, false);
    }

    public boolean check(String word, Boolean isComplete) {
        int n = word.length();
        Node curr = root;
        int i = 0;
        for (i = 0; i < n; i++) {
            curr = curr.map.get(word.charAt(i));
            if (curr == null) {
                return false;
            }
            if (isComplete && i == n-1) {
                return curr.isEnd;
            }
        }
        return true;
    }

    class Node {
        Map<Character, Node> map;
        Boolean isEnd;
        public Node() {
            map = new HashMap<>();
            isEnd = false;
        }
    }
}
