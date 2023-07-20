package leetcode.datastructure;


import java.util.HashMap;

class LFUCache {

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

        LFUCache lfuCache2 = new LFUCache(2);
        lfuCache2.put(3, 1);
        lfuCache2.put(2, 1);
        lfuCache2.put(2, 2);
        lfuCache2.put(4, 4);
        System.out.println(lfuCache2.get(2));
    }

    /**
     * 双向链表节点
     */
    static class Node {

        Node left;

        Node right;

        int key;

        int value;

        int accessNum;

        public Node(int key, int value, int accessNum) {
            this.key = key;
            this.value = value;
            this.accessNum = accessNum;
        }

    }

    private HashMap<Integer, Node> keyNodeMap;

    private HashMap<Integer, Node> accessNodeMap;

    private int minAccessNum;

    private int capacity;

    public LFUCache(int capacity) {
        keyNodeMap = new HashMap<>(capacity);
        accessNodeMap = new HashMap<>(capacity);
        minAccessNum = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            // 如果所在链表只有一个节点的话，那么直接将该访问次数的链表删掉
            Node sentinelHead = accessNodeMap.get(node.accessNum);
            if (sentinelHead.left == sentinelHead.right) {
                accessNodeMap.remove(node.accessNum);
                // 维护缓存中最小的访问次数
                if (minAccessNum == node.accessNum) {
                    minAccessNum++;
                }
            } else {
                // 断开与原链表的连接
                node.left.right = node.right;
                node.right.left = node.left;
            }

            // 增加后的访问次数链表看看有没有
            node.accessNum++;
            if (accessNodeMap.containsKey(node.accessNum)) {
                Node target = accessNodeMap.get(node.accessNum);
                // 插入头节点
                insertHead(node, target);
            } else {
                // 带有哨兵的循环双向链表
                Node head = initialSentinelLinkedList(node);
                // 没有对应的链表 直接插入
                accessNodeMap.put(node.accessNum, head);
            }

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            // 执行get方法
            get(key);
        } else {
            Node node = new Node(key, value, 1);
            if (keyNodeMap.size() == capacity) {
                // 容量不够需要将最少使用的节点移除
                Node sentinel = accessNodeMap.get(minAccessNum);

                Node tail = sentinel.left;
                // 如果所在链表只有一个节点的话，那么直接将该访问次数的链表删掉
                if (sentinel.left == sentinel.right) {
                    accessNodeMap.remove(minAccessNum);
                } else {
                    // 断开与原链表的连接
                    tail.left.right = tail.right;
                    tail.right.left = tail.left;
                }
                keyNodeMap.remove(tail.key);
            }
            // 这样就有有足够的容量了
            keyNodeMap.put(key, node);

            // 是否有对应的链表
            if (accessNodeMap.containsKey(node.accessNum)) {
                // 插入头节点
                insertHead(node, accessNodeMap.get(node.accessNum));
            } else {
                // 带有哨兵的循环双向链表
                Node head = initialSentinelLinkedList(node);
                // 没有对应的链表 直接插入
                accessNodeMap.put(node.accessNum, head);
            }
            minAccessNum = 1;
        }
    }

    private void insertHead(Node node, Node target) {
        node.left = target;
        node.right = target.right;
        target.right.left = node;
        target.right = node;
    }

    private Node initialSentinelLinkedList(Node node) {
        Node sentinel = new Node(-1, -1, -1);

        // 构建双向循环链表
        sentinel.right = node;
        sentinel.left = node;
        node.left = sentinel;
        node.right = sentinel;

        return sentinel;
    }

}
