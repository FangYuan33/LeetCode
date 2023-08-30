package leetcode.datastructure;

import java.util.HashMap;

public class LRUCache {

    static class Node {

        int key;

        int val;

        Node next;

        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> keyNode;

    int capacity;

    Node sentinel;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNode = new HashMap<>();

        sentinel = new Node(-1, -1);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }

    public int get(int key) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            // 移动到头节点
            removeToHead(node);

            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.val = value;

            removeToHead(node);
        } else {
            if (keyNode.size() == capacity) {
                Node tail = sentinel.pre;
                keyNode.remove(tail.key);

                tail.pre.next = sentinel;
                tail.next.pre = tail.pre;
            }

            Node node = new Node(key, value);
            // 加入头节点
            insertToHead(node);
            keyNode.put(key, node);
        }
    }

    private void removeToHead(Node node) {
        // 在原位置移除
        node.pre.next = node.next;
        node.next.pre = node.pre;

        // 放到头节点
        insertToHead(node);
    }

    private void insertToHead(Node node) {
        sentinel.next.pre = node;
        node.next = sentinel.next;
        sentinel.next = node;
        node.pre = sentinel;
    }
}
