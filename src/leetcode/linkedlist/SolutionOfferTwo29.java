package leetcode.linkedlist;

public class SolutionOfferTwo29 {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        node.next = node;

        if (head == null) {
            return node;
        }

        Node current = head;
        // 找到实际的最小头节点，重复节点也往后走（如果是重复节点的话，需要避免无限循环）
        while (current.val < current.next.val || (current.val == current.next.val && current.next != head)) {
            current = current.next;
        }
        // pre 为尾巴节点
        Node pre = current;
        current = current.next;

        // 如果是单个节点或者插入的值是最大的节点
        if (current == current.next || pre.val < insertVal) {
            // 指针位置不变
        } else {
            // 非特殊情况，找到合适的位置
            while (current.val < insertVal) {
                pre = pre.next;
                current = current.next;
            }
        }

        // 插入
        pre.next = node;
        node.next = current;

        return head;
    }
}
