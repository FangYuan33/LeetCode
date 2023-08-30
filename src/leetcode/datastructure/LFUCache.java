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

        int key, value;

        Node pre, next;

        int accessNum;

        public Node(int key, int value, int accessNum) {
            this.key = key;
            this.value = value;
            this.accessNum = accessNum;
        }
    }

    /**
     * 记录访问最小的值
     */
    private int minAccessNum;

    private final int capacity;

    private final HashMap<Integer, Node> accessNodeMap;

    private final HashMap<Integer, Node> keyNodeMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        accessNodeMap = new HashMap<>(capacity);
        keyNodeMap = new HashMap<>(capacity);

        // 初始化访问次数为 1 的哨兵节点
        minAccessNum = 1;
        accessNodeMap.put(minAccessNum, initialSentinelNode(minAccessNum));
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            // 找到新的位置
            insertIntoNextSentinel(node);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;

            insertIntoNextSentinel(node);
        } else {
            if (keyNodeMap.size() == capacity) {
                // 移除最老的节点
                removeEldest();
            }
            // 新加进来的肯定是最小访问次数 1
            minAccessNum = 1;
            Node newNode = new Node(key, value, minAccessNum);

            // 插入到头节点
            insertIntoHead(newNode, accessNodeMap.get(minAccessNum));
            keyNodeMap.put(key, newNode);
        }
    }

    /**
     * 插入下一个链表中
     */
    private void insertIntoNextSentinel(Node node) {
        // 在原来的位置移除
        remove(node);
        // 尝试更新 minAccessNum
        tryToIncreaseMinAccessNum(node.accessNum++);
        // 获取增加 1 后的哨兵节点
        Node nextCacheSentinel = getSpecificAccessNumSentinel(node.accessNum);
        // 插入该链表的头节点
        insertIntoHead(node, nextCacheSentinel);
    }

    /**
     * 在原链表中移除
     */
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }

    /**
     * 尝试更新 minAccessNum
     */
    private void tryToIncreaseMinAccessNum(int accessNum) {
        // 原访问次数的哨兵节点
        Node originSentinel = accessNodeMap.get(accessNum);
        // 如果只剩下哨兵节点的话，需要看看需不需要把 minAccessNum 增加 1
        if (originSentinel.next == originSentinel && originSentinel.accessNum == minAccessNum) {
            minAccessNum++;
        }
    }

    /**
     * 获取指定访问次数的哨兵节点
     */
    private Node getSpecificAccessNumSentinel(int accessNum) {
        if (accessNodeMap.containsKey(accessNum)) {
            return accessNodeMap.get(accessNum);
        } else {
            // 没有的话得初始化一个
            Node nextCacheSentinel = initialSentinelNode(accessNum);
            accessNodeMap.put(accessNum, nextCacheSentinel);

            return nextCacheSentinel;
        }
    }

    /**
     * 生成具体访问次数的哨兵节点
     */
    private Node initialSentinelNode(int accessNum) {
        Node sentinel = new Node(-1, -1, accessNum);
        // 双向循环链表
        sentinel.next = sentinel;
        sentinel.pre = sentinel;

        return sentinel;
    }

    /**
     * 插入头节点
     */
    private void insertIntoHead(Node node, Node nextCacheSentinel) {
        node.next = nextCacheSentinel.next;
        nextCacheSentinel.next.pre = node;
        nextCacheSentinel.next = node;
        node.pre = nextCacheSentinel;
    }

    /**
     * 如果容量满了的话，需要把 minAccessNum 访问次数的尾巴节点先移除掉
     */
    private void removeEldest() {
        Node minSentinel = accessNodeMap.get(minAccessNum);

        Node tail = minSentinel.pre;
        tail.pre.next = tail.next;
        minSentinel.pre = tail.pre;
        keyNodeMap.remove(tail.key);
    }
}
