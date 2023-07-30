package leetcode.datastructure;

import java.util.HashMap;

public class AllOne {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        allOne.inc("hello");
        allOne.inc("l");
        allOne.inc("l");
        allOne.inc("l");

        allOne.inc("k");
        allOne.inc("k");
        allOne.inc("k");

        allOne.inc("j");
        allOne.inc("j");
        allOne.inc("j");

        allOne.dec("j");
        allOne.dec("k");

        System.out.println(allOne.getMaxKey());
    }

    static class Node {
        String key;

        int num;

        Node prev;

        Node next;

        public Node(String key, Integer num) {
            this.key = key;
            this.num = num;
        }
    }

    // 思路：实现 O(1) 的访问，那么我们需要创建一个 map，key 为字符串，value 为保存对应次数的链表节点
    // 双向链表实现对值的保存，新加入的直接向头结点放，如果一个值的访问次数增加后比尾节点大，那么把它移动到尾节点的后面，否则将它放到尾节点的前面
    public AllOne() {
        keyNodeMap = new HashMap<>();
        // 构建双向循环链表
        sentinel = new Node("", -1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    private final HashMap<String, Node> keyNodeMap;

    private final Node sentinel;

    public void inc(String key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.num++;

            // 先删除
            deleteNode(node);

            Node tail = sentinel.prev;
            if (node.num < tail.num) {
                // 比尾巴节点小，放到尾巴节点前面
                Node prev = tail.prev;
                prev.next = node;
                node.prev = prev;
                node.next = tail;
                tail.prev = node;
            } else {
                // 比尾巴节点大，放到尾巴节点后边
                tail.next = node;
                node.prev = tail;
                node.next = sentinel;
                sentinel.prev = node;
            }
        } else {
            Node node = new Node(key, 1);
            // 插入头节点位置
            Node oldHead = sentinel.next;
            sentinel.next = node;
            node.prev = sentinel;
            node.next = oldHead;
            oldHead.prev = node;

            keyNodeMap.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = keyNodeMap.get(key);
        node.num--;

        // 先删除
        deleteNode(node);
        if (node.num == 0) {
            keyNodeMap.remove(key);
        } else {
            // 如果比尾节点大，则放在尾节点后边
            Node tail = sentinel.prev;
            if (node.num > tail.num) {
                tail.next = node;
                node.prev = tail;
                node.next = sentinel;
                sentinel.prev = node;
            } else {
                // 如果比头节点大，则放在头节点后面
                Node head = sentinel.next;
                if (node.num >= head.num) {
                    Node next = head.next;

                    head.next = node;
                    node.prev = head;
                    node.next = next;
                    next.prev = node;
                } else {
                    // 否则放在头节点前面
                    sentinel.next = node;
                    node.prev = sentinel;
                    node.next = head;
                    head.prev = node;
                }
            }

        }
    }

    /**
     * 在连表中删除节点
     */
    private void deleteNode(Node node) {
        // 删除节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public String getMaxKey() {
        if (keyNodeMap.isEmpty()) {
            return "";
        } else {
            return sentinel.prev.key;
        }
    }

    public String getMinKey() {
        if (keyNodeMap.isEmpty()) {
            return "";
        } else {
            return sentinel.next.key;
        }
    }
}
