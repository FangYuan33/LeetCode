package leetcode.datastructure;

import java.util.HashMap;

/**
 * HashMap 和 双向链表实现 LRU 缓存
 *
 * @author FangYuan
 * @since 2023-07-18 20:35:51
 */
public class LRUCacheHashMap {

    public static void main(String[] args) {
        LRUCacheHashMap lru = new LRUCacheHashMap(1);

        lru.put(2, 1);
        System.out.println(lru.get(2));
        lru.put(3, 2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
    }

    static class ListNode {

        ListNode left;

        ListNode right;

        int key, value;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMap<Integer, ListNode> map;

    private final ListNode sentinel;

    private final int capacity;

    /**
     * 定义访问过的节点移动到尾节点
     */
    public LRUCacheHashMap(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        // 定义单个哨兵节点形成双向循环链表来简化边界条件的判断
        ListNode sentinel = new ListNode(-1, -1);
        this.sentinel = sentinel;
        sentinel.right = sentinel;
        sentinel.left = sentinel;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            // 将该节点移动到尾节点
            refresh(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            // 如果已经有这个节点则需要将其移动到尾节点
            refresh(node);
        } else {
            ListNode node = new ListNode(key, value);
            // 没有的话先判断容量
            if (map.size() == capacity) {
                // 先移除头节点
                ListNode head = sentinel.right;
                map.remove(head.key);
                sentinel.right = head.right;
                head.right.left = sentinel;
            }
            // 插入到尾节点
            insert(node);
            // 管理到 map 中
            map.put(key, node);
        }
    }

    /**
     * 移动该节点到尾节点
     */
    private void refresh(ListNode node) {
        ListNode pre = node.left, next = node.right;
        // 处理前驱节点 pre
        pre.right = next;
        // 处理后继节点 next
        next.left = pre;

        ListNode tail = sentinel.left;
        // 将当前节点移动到尾节点
        tail.right = node;
        node.left = tail;
        // 构建双向循环链表
        node.right = sentinel;
        sentinel.left = node;
    }

    /**
     * 添加到尾节点
     */
    private void insert(ListNode node) {
        ListNode tail = sentinel.left;
        // 添加到尾节点
        tail.right = node;
        node.left = tail;
        // 双向循环链表
        node.right = sentinel;
        sentinel.left = node;
    }
}
