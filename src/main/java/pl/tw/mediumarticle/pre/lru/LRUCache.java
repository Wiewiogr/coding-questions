package pl.tw.mediumarticle.pre.lru;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    Node first = new Node(-1, -1);
    Node last = new Node(-1, -2);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node val = map.get(key);

            val.prev.next = val.next;
            val.next.prev = val.prev;

            Node oldNext = first.next;

            first.next = val;
            val.prev = first;

            val.next = oldNext;
            val.next.prev = val;

            return val.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node val = map.get(key);

            val.prev.next = val.next;
            val.next.prev = val.prev;

            map.remove(key);
        }

        Node node = new Node(key, value);

        Node oldNext = first.next;

        first.next = node;
        node.prev = first;

        node.next = oldNext;
        node.next.prev = node;

        map.put(key, node);

        if (map.size() > capacity) {
            Node nodeToRemove = last.prev;
            nodeToRemove.prev.next = last;
            last.prev = nodeToRemove.prev;
            map.remove(nodeToRemove.key);
        }
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", prev=" + prev.value +
                    ", next=" + next.value +
                    '}';
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        System.out.println(lRUCache.map);
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.map);
        lRUCache.get(1);    // return 1
        System.out.println(lRUCache.map);
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.map);
        lRUCache.get(2);    // returns -1 (not found)
        System.out.println(lRUCache.map);
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.map);
        lRUCache.get(1);    // return -1 (not found)
        System.out.println(lRUCache.map);
        lRUCache.get(3);    // return 3
        System.out.println(lRUCache.map);
        lRUCache.get(4);    // return 4
        System.out.println(lRUCache.map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */