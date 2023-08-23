package leetcode.datastructure;

import java.util.HashMap;

public class LRUCache {

    static class LinkedListNode {

        int val;

        int key;

        LinkedListNode next;

        LinkedListNode pre;

        public LinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;

    private final HashMap<Integer, LinkedListNode> map;

    private final LinkedListNode sentinel;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        sentinel = new LinkedListNode(-1, -1);
        // 链表的哨兵节点
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedListNode node = map.get(key);
            // 在原位置删除并移动到头节点
            toHead(node);

            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedListNode node = map.get(key);
            node.val = value;

            toHead(node);
        } else {
            if (capacity == map.size()) {
                // 移除尾巴节点
                LinkedListNode tail = sentinel.pre;
                sentinel.pre = tail.pre;
                sentinel.pre.next = sentinel;
                map.remove(tail.key);
            }
            LinkedListNode newHead = new LinkedListNode(key, value);
            // 放到头节点
            insertHead(newHead);

            map.put(key, newHead);
        }
    }

    private void toHead(LinkedListNode node) {
        // 在原位置删除并移动到头节点
        node.pre.next = node.next;
        node.next.pre = node.pre;

        insertHead(node);
    }

    private void insertHead(LinkedListNode newHead) {
        newHead.next = sentinel.next;
        sentinel.next.pre = newHead;
        sentinel.next = newHead;
        newHead.pre = sentinel;
    }
}
