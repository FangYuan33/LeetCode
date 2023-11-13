package leetcode.datastructure;

import java.util.HashMap;

public class LRUCache {

    static class Node {

        int key;

        int value;

        Node pre;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;

    Node sentinel;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        sentinel = new Node(-1, -1);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cutOriginalLink(node);
            insertToHead(node);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            cutOriginalLink(node);
        } else {
            node = new Node(key, value);
            if (map.size() == capacity) {
                Node tail = sentinel.pre;
                // 去掉尾巴
                map.remove(tail.key);
                cutOriginalLink(tail);
            }
            map.put(key, node);
        }
        insertToHead(node);
    }

    /**
     * 断开原来的链接
     */
    private void cutOriginalLink(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 插入到头
     */
    private void insertToHead(Node node) {
        node.next = sentinel.next;
        sentinel.next.pre = node;
        node.pre = sentinel;
        sentinel.next = node;
    }
}
