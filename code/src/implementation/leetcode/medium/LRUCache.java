package implementation.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
public class LRUCache {
    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.head.prev = null;
        this.tail.next = null;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // if we have the key then retrieve its value and delete and put at front (after the head)
        Node node = map.get(key);
        deleteNode(node);
        insertNodeAfterHead(node);

        return node.value;
        // time: O(1)
    }


    public void put(int key, int value) {
        // if it already presents, update the value and delete and put it after head
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            deleteNode(node);
            insertNodeAfterHead(node);
        } else {
            // if capacity is full
            if (map.size() == this.capacity){
                // delete the last node (also from the map)
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            // create a new node
            Node node = new Node(key, value);
            map.put(key, node);
            insertNodeAfterHead(node);
        }
        // time: O(1)
    }

    private void insertNodeAfterHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class Node {
        private int key;
        private int value;
        private Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
